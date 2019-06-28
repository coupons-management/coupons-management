package com.gopher.system.service.impl;

import com.gopher.system.constant.SystemConstants;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.dao.mysql.SpiderStatisticDAO;
import com.gopher.system.dao.mysql.StatisticDAO;
import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.entity.SpiderStatistic;
import com.gopher.system.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StatisticRequest;
import com.gopher.system.model.vo.response.StatisticResponse;
import com.gopher.system.service.StatisticService;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author dongyangyang
 * 统计
 */
@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private SpiderStatisticDAO spiderStatisticDAO;

    @Autowired
    private StatisticDAO statisticDAO;
    @Autowired
    private CpScrapyDAO cpScrapyDAO;

    @Override
    @Deprecated
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
        List<SpiderStatistic> list = spiderStatisticDAO.findList(statisticRequest);

        List<StatisticResponse> result = new ArrayList<>();
        Map<String, StatisticResponse> temp = new HashMap<>();
        Set<Integer> store_update = new HashSet<>();
        if (null != list) {
            for (SpiderStatistic spiderStatistic : list) {
                String key = "";
                if (Objects.equals(ranger, SystemConstants.DATE_RANGE_DAY.getValue())) {
                    key = DateUtils.getDateString(spiderStatistic.getCreateTime());
                } else if (Objects.equals(ranger, SystemConstants.DATE_RANGE_WEEK.getValue())) {
                    key = (DateUtils.getDateString(DateUtils.getWeekStart(spiderStatistic.getCreateTime())) + "~" + DateUtils.getDateString(DateUtils.getWeekEnd(spiderStatistic.getCreateTime())));
                } else if (Objects.equals(ranger, SystemConstants.DATE_RANGE_MONTH.getValue())) {
                    key = DateUtils.getDateString(spiderStatistic.getCreateTime(), "yyyy-MM");
                }
                StatisticResponse value = temp.get(key);
                if (null == value) {
                    value = new StatisticResponse();
                    value.setDate(key);
                }
                value.setTotalCoupon(value.getTotalCoupon() + spiderStatistic.getTotalCoupon());
                value.setIncrementCoupon(value.getIncrementCoupon() + spiderStatistic.getIncrementCoupon());
                value.setValidCoupon(value.getValidCoupon() + spiderStatistic.getValidCoupon());
                value.setIncrementStore(value.getIncrementStore() + spiderStatistic.getIsNewStore());

                if (spiderStatistic.getIncrementCoupon() > 0 && store_update.add(spiderStatistic.getStoreId())) {
                    value.setUpdateStore(value.getUpdateStore() + 1);
                }
                temp.put(key, value);
            }
        }
        if (null != temp) {
            temp.forEach((k, v) ->
                    result.add(v)
            );
        }
        result.sort((e1, e2) -> {
            if (e1.getDate().compareTo(e2.getDate()) == 0) {
                return 1;
            } else {
                return e2.getDate().compareTo(e1.getDate());
            }

        });
        return result;
    }


    /**
     * 爬虫端统计 直接根据时间段 查询优惠券 增量,有效数量,总量,
     * 根据时间段取查询商家 增量
     *
     * @param statisticRequest
     * @return
     */
    @Override
    public List<StatisticResponse> getStatisticBySpider(StatisticRequest statisticRequest) {
        // TODO 如果是天 获取这个时间段内每一天的开始和结束时间
        //      如果是周 获取这个时间段内的每一周的开始和结束
        //      如果是月 获取这个时间段内的没一月的开始和结束
        List<StatisticResponse> result = new ArrayList<>();
        final int range = statisticRequest.getRange();
        this.setSpider(statisticRequest);
        List<_Date> timeList = this.getAllTime(statisticRequest);
        for (_Date date : timeList) {
            StatisticRequest query = new StatisticRequest();

            query.setBeginDate(new Date(date.beginTime));
            query.setEndDate(new Date(date.endTime));
            final int totalCoupon = statisticDAO.getCouponTotalCount(query);
            final int validCoupon = statisticDAO.getCouponValidCount(query);
            final int incrementCoupon = statisticDAO.getCouponIncrementCount(query);
            final int incrementStore = statisticDAO.getStoreIncrementCount(query);
            final int updateStore = statisticDAO.getStoreUpdateCount(query);
            StatisticResponse rsp = new StatisticResponse();
            rsp.setTotalCoupon(totalCoupon);
            rsp.setValidCoupon(validCoupon);
            rsp.setIncrementCoupon(incrementCoupon);
            rsp.setIncrementStore(incrementStore);
            rsp.setUpdateStore(updateStore);
            if (Objects.equals(range, SystemConstants.DATE_RANGE_DAY.getValue())) {
                rsp.setDate(DateUtils.getDateString(date.endTime));
            } else {
                rsp.setDate(DateUtils.getDateString(date.beginTime)+"~"+DateUtils.getDateString(date.endTime));
            }
            result.add(rsp);
        }
        return result;
    }

    public void setSpider(StatisticRequest statisticRequest) {
        final int spiderId = statisticRequest.getSpiderId();
        if (spiderId <= 0) {
            return;
        }
        CpScrapy cpScrapy = cpScrapyDAO.selectByPrimaryKey(spiderId);
        if (null != cpScrapy) {
            statisticRequest.setSpider(cpScrapy.getName());
        }
    }

    class _Date {
        _Date(long beginTime ,long endTime){
            this.beginTime = beginTime;
            this.endTime = endTime;
        }
        private long beginTime;
        private long endTime;

        public long getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(long beginTime) {
            this.beginTime = beginTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }
    }

    private List<_Date> getAllTime(StatisticRequest statisticRequest) {
        final int ranger = statisticRequest.getRange();
        final long benginTime = statisticRequest.getBeginTime();
        final long endTime = statisticRequest.getEndTime();
        List<_Date> result = new ArrayList<>();
        long temp = benginTime;
        long diff = 24 * 60 * 60 * 1000L;
        if (Objects.equals(ranger, SystemConstants.DATE_RANGE_DAY.getValue())) {

        } else if (Objects.equals(ranger, SystemConstants.DATE_RANGE_WEEK.getValue())) {
            diff = 7 * diff;
        } else if (Objects.equals(ranger, SystemConstants.DATE_RANGE_MONTH.getValue())) {
            diff = 30 * diff;
        }
        while (temp < endTime) {
            result.add(new _Date(temp,temp += diff));
        }
        return result;
    }

    /**
     * 加一层站点条件
     *
     * @param statisticRequest
     * @return
     */
    @Override
    public List<StatisticResponse> getStatisticBySite(StatisticRequest statisticRequest) {
        //TODO
        return null;
    }


}
