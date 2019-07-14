package com.gopher.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.gopher.system.dao.mysql.*;
import com.gopher.system.model.entity.*;
import com.gopher.system.model.vo.response.CouponResultsOfScore;
import com.gopher.system.service.MessageDataService;
import com.gopher.system.util.DateUtils;
import com.gopher.system.util.SpiderStatusJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class MessageDataServiceImpl implements MessageDataService {
    @Autowired
    SynMessageDataDao synMessageDataDao;
    @Autowired
    CpScrapyRecodeDAO cpScrapyRecodeDAO;
    @Autowired
    CpCouponCensusDAO cpCouponCensusDAO;
    @Autowired
    CpScrapyDAO cpScrapyDAO;
    @Autowired
    CpCouponDAO cpCouponDAO;

    @Override
    public List<TMessage> getStoreMessages() {
        return synMessageDataDao.getStoreMessages();
    }

    @Override
    public void insertStoreMessages(TMessage message) {
        synMessageDataDao.insertStoreMessages(message);
    }

    @Override
    public void insertCouponMessages(TMessage message) {
        synMessageDataDao.insertCouponMessages(message);

    }

    @Override
    public void insertCategoryMessages(TMessage message) {
        synMessageDataDao.insertCategoryMessages(message);

    }

    @Override
    public void insertScrapyRecode(CpScrapyRecode record) {
        cpScrapyRecodeDAO.insert(record);

    }

    @Override
    public void updateScrapyRecode(CpScrapyRecode record) {
        cpScrapyRecodeDAO.updateByPrimaryKey(record);

    }
    @Autowired
    private CpScrapyStoreDAO cpScrapyStoreDAO;
    @Override
    public void updateCouponIndex(String msg) {
        final String status_start = "start";
        final String status_stop = "stop";
        SpiderStatusJson json = JSON.parseObject(msg, SpiderStatusJson.class);
        final String spider_name = json.getSpider();
        CpScrapyRecode recode = cpScrapyRecodeDAO.getBeanByScrapyName(spider_name);
        if (recode == null) {
            recode = new CpScrapyRecode();
            recode.setScrapyName(json.getSpider());
            if (Objects.equals(status_start, json.getStatus())) {
                recode.setStatus("1");
            } else {
                recode.setStatus("0");
            }
            recode.setStartTime(DateUtils.getDateTime(json.getTime()));
            cpScrapyRecodeDAO.insert(recode);
            return;
        } else {
            recode.setScrapyName(json.getSpider());
            if (Objects.equals(status_start, json.getStatus())) {
                recode.setStatus("1");
            } else {
                recode.setStatus("0");
            }
            recode.setEndTime(json.getEndTime());
            cpScrapyRecodeDAO.updateByPrimaryKeySelective(recode);
        }
        CpScrapy spider = cpScrapyDAO.getBeanByName(spider_name);
        if(null == spider){
            return;
        }
//        CpScrapyStore query  = new CpScrapyStore();
//        query.setScrapyId(spider.getId());
//        List<CpScrapyStore> cpScrapyStoreList = cpScrapyStoreDAO.getList(query);
//        if(!CollectionUtils.isEmpty(cpScrapyStoreList)){
//            cpScrapyStoreList.forEach(e->{
//                List<CouponResultsOfScore> scoreList = cpCouponCensusDAO.getCouponResultsOfScore(e.getStoreId());
//                Map<Integer, Integer> final_sort = new HashMap<>();
//                // 计算和
//                for (CouponResultsOfScore couponResultsOfScore : scoreList) {
//                    final int cooupon_id = couponResultsOfScore.getCouponId();
//                    Integer score = final_sort.get(cooupon_id);
//                    if (null == score) {
//                        score = couponResultsOfScore.getSort();
//                    } else {
//                        score += couponResultsOfScore.getSort();
//                    }
//                    final_sort.put(cooupon_id, score);
//                }
//                Set<Integer> keys = final_sort.keySet();
//
//                for (Integer cooupon_id : keys) {
//                    // 更新每一条
//                    CpCoupon pon = new CpCoupon();
//                    pon.setId(cooupon_id);
//                    pon.setIndex(final_sort.get(cooupon_id));
//                    cpCouponDAO.updateByPrimaryKeySelective(pon);
//                }
//            });
//        }


    }

    @Override
    public List<CpScrapy> getScrapyList() {
        return cpScrapyDAO.getList();

    }


}
