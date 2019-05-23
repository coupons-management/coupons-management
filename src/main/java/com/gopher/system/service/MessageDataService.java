package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.TMessage;

public interface MessageDataService {
	public List<TMessage> getStoreMessages() ;
	public void insertStoreMessages(TMessage message) ;
	public void insertCouponMessages(TMessage message) ;
	public void insertScrapyeMessages(TMessage message) ;

}
