package com.gopher.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.SynMessageDataDao;
import com.gopher.system.model.entity.TMessage;
import com.gopher.system.service.MessageDataService;
@Service
public class MessageDataServiceImpl implements MessageDataService {
	@Autowired
	SynMessageDataDao synMessageDataDao;
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
	public void insertScrapyeMessages(TMessage message) {
		synMessageDataDao.insertScrapyeMessages(message);
		
	}

}
