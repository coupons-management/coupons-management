package com.gopher.system.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gopher.system.dao.mysql.CpCouponCensusDAO;
import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.dao.mysql.CpScrapyRecodeDAO;
import com.gopher.system.dao.mysql.SynMessageDataDao;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpCouponCensus;
import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.entity.CpScrapyRecode;
import com.gopher.system.model.entity.TMessage;
import com.gopher.system.model.vo.response.CouponResultsOfScore;
import com.gopher.system.service.MessageDataService;
import com.gopher.system.util.CouPonJson;
import com.gopher.system.util.SpiderStatusJson;
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
	@Override
	public void updateCouponIndex(String msg) {
		final String status_start = "start";
		final String status_stop  = "stop";
		JSONObject jsonObject = JSONObject.parseObject(msg);
		SpiderStatusJson json = (SpiderStatusJson) JSONObject.toJavaObject(jsonObject, SpiderStatusJson.class);
		
		CpScrapyRecode recode=cpScrapyRecodeDAO.getBeanByScrapyName(json.getSpider());
		if(recode==null)
		{     recode=new CpScrapyRecode();
			  recode.setScrapyName(json.getSpider());
			  if(Objects.equals(status_start,json.getStatus())){
				  recode.setStatus("1");
			  }else{
				  recode.setStatus("0");
			  }
		      recode.setEndTime(json.getEndTime());
		      cpScrapyRecodeDAO.insert(recode);
		}else {
			  recode.setScrapyName(json.getSpider());
			if(Objects.equals(status_start,json.getStatus())){
				recode.setStatus("1");
			}else{
				recode.setStatus("0");
			}
			  recode.setEndTime(json.getEndTime());
		      cpScrapyRecodeDAO.updateByPrimaryKey(recode);	
		}
		
		// 查找站点下的所有权重
		List<CouponResultsOfScore> scoreList = cpCouponCensusDAO.getCouponResultsOfScore();
		Map<Integer,Integer> final_sort = new HashMap<>();
		
		// 计算和
		for (CouponResultsOfScore couponResultsOfScore : scoreList) {	
			final int cooupon_id = couponResultsOfScore.getCouponId();
			Integer score = final_sort.get(cooupon_id);
			if(null == score){
				score = couponResultsOfScore.getSort() *couponResultsOfScore.getWeight();
			}else{
				score += couponResultsOfScore.getSort() *couponResultsOfScore.getWeight();
			}
			final_sort.put(cooupon_id, score);
		}
		Set<Integer> keys = final_sort.keySet();
		
		for (Integer cooupon_id : keys) {
			// 更新每一条
			CpCoupon pon = new CpCoupon();
			pon.setId(cooupon_id);
			pon.setIndex(final_sort.get(cooupon_id));
			cpCouponDAO.updateByPrimaryKeySelective(pon);
		}
		
	}
	@Override
	public List<CpScrapy> getScrapyList() {
		return cpScrapyDAO.getList();
	
	}
	
	

	

}
