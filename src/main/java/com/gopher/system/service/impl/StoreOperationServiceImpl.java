package com.gopher.system.service.impl;

import com.gopher.system.constant.SystemConstants;
import com.gopher.system.dao.mysql.SpiderStatisticDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.SpiderStatistic;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StatisticRequest;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.StoreOperationService;
import com.gopher.system.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StoreOperationServiceImpl implements StoreOperationService {
    @Autowired
    private StoreService storeService;
    @Autowired
    private SpiderStatisticDAO spiderStatisticDAO;
    private static final Logger LOG = LoggerFactory.getLogger(StoreOperationServiceImpl.class);

    @Override
    public Page<StoreResponse> getPage(StorePageRequst storePageRequest) {
        if(null == storePageRequest){
            throw new BusinessRuntimeException("参数不能为空");
        }
        final long beginTime = storePageRequest.getBeginTime();
        final long endTime   = storePageRequest.getEndTime();
        if(beginTime <= 0){
            throw new BusinessRuntimeException("开始时间不能为空");
        }
        if(endTime <= 0){
            throw new BusinessRuntimeException("结束时间不能为空");
        }
        final int range = storePageRequest.getRange();
        StatisticRequest statisticRequest = new StatisticRequest();
        statisticRequest.setBeginDate(new Date(beginTime));
        statisticRequest.setEndDate(new Date(endTime));
        statisticRequest.setRange(SystemConstants.DATE_RANGE_DAY.getValue());
        List<SpiderStatistic> list = spiderStatisticDAO.findList(statisticRequest);
        Page<StoreResponse> result = new Page<StoreResponse>();
        if(null != list && !list.isEmpty()){
            List<Integer> storeIdList = new ArrayList<>();
            if (range == 1){// 有新增优惠券的商家
                list.forEach(item->{
                    if(item.getIncrementCoupon() > 0){
                        storeIdList.add(item.getStoreId());
                    }

                });
            }else if(range == 2){//无新增优惠券的商家
                list.forEach(item->{
                    if(item.getIncrementCoupon() == 0){
                        storeIdList.add(item.getStoreId());
                    }

                });
            }else {//新增的商家
                list.forEach(item->{
                    if(item.getIsNewStore() == 1){
                        storeIdList.add(item.getStoreId());
                    }

                });
            }
            LOG.info("商家ID集合:{}",storeIdList);
            if(!storeIdList.isEmpty()){
                storePageRequest.setStoreIdList(storeIdList);
                result = storeService.getPage(storePageRequest);
            }

        }
        return result ;
    }
}
