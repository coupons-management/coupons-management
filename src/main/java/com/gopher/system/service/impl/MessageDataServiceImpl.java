package com.gopher.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gopher.system.dao.mysql.CpCouponCensusDAO;
import com.gopher.system.dao.mysql.CpScrapyDAO;
import com.gopher.system.dao.mysql.CpScrapyRecodeDAO;
import com.gopher.system.dao.mysql.SynMessageDataDao;
import com.gopher.system.model.entity.CpCouponCensus;
import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.entity.CpScrapyRecode;
import com.gopher.system.model.entity.TMessage;
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
		JSONObject jsonObject = JSONObject.parseObject(msg);
		SpiderStatusJson json = (SpiderStatusJson) JSONObject.toJavaObject(jsonObject, SpiderStatusJson.class);
		
		CpScrapyRecode recode=cpScrapyRecodeDAO.getBeanByScrapyName(json.getSpider());
		if(recode==null)
		{     recode=new CpScrapyRecode();
			  recode.setScrapyName(json.getSpider());
		      recode.setStatus(json.getStatus());
		      recode.setEndTime(json.getEndTime());
		      cpScrapyRecodeDAO.insert(recode);
		}else {
			   recode.setScrapyName(json.getSpider());
			   recode.setStatus(json.getStatus());
			   recode.setEndTime(json.getEndTime());
		      cpScrapyRecodeDAO.updateByPrimaryKey(recode);	
		}
		
		
		
		//1:爬虫更新时间小于本次开始时间的爬虫数据清0
		CpCouponCensus cen=new CpCouponCensus();
		cen.setScrapyTime(recode.getStartTime());
		cen.setScrapyName(json.getSpider());
		cpCouponCensusDAO.updateExpire(cen);
		
		//2:修改优惠卷中的排名
		cpCouponCensusDAO.updateCouponIndex();
		
	
		
	}
	@Override
	public List<CpScrapy> getScrapyList() {
		return cpScrapyDAO.getList();
	
	}
	
	

	

}
