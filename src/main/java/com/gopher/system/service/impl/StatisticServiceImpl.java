package com.gopher.system.service.impl;

import com.gopher.system.constant.SystemConstants;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.dao.mysql.SpiderStatisticDAO;
import com.gopher.system.model.entity.SpiderStatistic;
import com.gopher.system.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StatisticRequest;
import com.gopher.system.model.vo.response.StatisticResponse;
import com.gopher.system.service.StatisticService;

import java.util.*;

/**
 * @author dongyangyang
 * 统计
 */
@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private SpiderStatisticDAO spiderStatisticDAO;

    @Override
    public List<StatisticResponse> getStatistic(StatisticRequest statisticRequest) {
        if (null == statisticRequest) {
            throw new BusinessRuntimeException("参数不能为空");
        }
        final long beginTime = statisticRequest.getBeginTime();
        final long endTime = statisticRequest.getEndTime();
        if (beginTime <= 0) {
            throw new BusinessRuntimeException("开始时间不能为空");
        }
        if (endTime <= 0) {
            throw new BusinessRuntimeException("结束时间不能为空");
        }
        final int ranger = statisticRequest.getRange();
        if (ranger <= 0) {
            throw new BusinessRuntimeException("请选择时间范围");
        }
        statisticRequest.setBeginDate(new Date(beginTime));
        statisticRequest.setEndDate(new Date(endTime));
        List<StatisticResponse> result = new ArrayList<>();
        Map<String, StatisticResponse> temp = new HashMap<>();
        Set<Integer> store_update = new HashSet<>();
        List<SpiderStatistic> list = spiderStatisticDAO.findList(statisticRequest);

        if (null != list) {
            for (SpiderStatistic spiderStatistic : list) {
                String key = "";
                if (Objects.equals(ranger, SystemConstants.DATE_RANGE_DAY.getValue())) {
                    key = DateUtils.getDateString(spiderStatistic.getCreateTime());
                } else if (Objects.equals(ranger, SystemConstants.DATE_RANGE_WEEK.getValue())) {
                    key = (DateUtils.getDateString(DateUtils.getWeekStart(spiderStatistic.getCreateTime()))+"~"+DateUtils.getDateString(DateUtils.getWeekEnd(spiderStatistic.getCreateTime())));
                } else if (Objects.equals(ranger, SystemConstants.DATE_RANGE_MONTH.getValue())) {
                    key = DateUtils.getDateString(spiderStatistic.getCreateTime(), "yyyy-MM");
                }
                StatisticResponse value = temp.get(key);
                if (null == value) {
                    value = new StatisticResponse();
                    value.setDate(key);
                }
                value.setIncrementCoupon(value.getIncrementCoupon() + spiderStatistic.getIncrementCoupon());
                value.setTotalCoupon(value.getTotalCoupon() + spiderStatistic.getTotalCoupon());
                value.setValidCoupon(value.getValidCoupon() + spiderStatistic.getValidCoupon());
                value.setIncrementStore(value.getIncrementStore() + spiderStatistic.getIsNewStore());
                if (spiderStatistic.getIncrementCoupon() > 0 && store_update.add(spiderStatistic.getStoreId())) {
                    value.setUpdateStore(value.getUpdateStore() + 1);
                }
                temp.put(key, value);
            }
        }
        if (null != temp) {
            temp.forEach((k, v) -> result.add(v));
        }
        return result;
    }

}
