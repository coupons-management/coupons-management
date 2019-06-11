package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpScrapyRecode;
import com.gopher.system.model.entity.TMessage;
public interface MessageDataService {
	public List<TMessage> getStoreMessages() ;
	public void insertStoreMessages(TMessage message) ;
	public void insertCouponMessages(TMessage message) ;
	public void insertCategoryMessages(TMessage message) ;
	public void insertScrapyRecode(CpScrapyRecode record);
	public void updateScrapyRecode(CpScrapyRecode record);
	public void updateCouponIndex(String msg);
	//public void insertSpiderStatus(SpiderStatusJson message) ;

}
