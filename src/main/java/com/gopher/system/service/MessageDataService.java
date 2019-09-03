package com.gopher.system.service;

import java.util.List;
import com.gopher.system.model.entity.CpScrapy;
import com.gopher.system.model.entity.TMessage;
public interface MessageDataService {
	public List<TMessage> getStoreMessages();
	public void insertStoreMessages(TMessage message);
	public void insertCouponMessages(TMessage message);
	public void insertCategoryMessages(TMessage message);
	public void updateScrapyRunState(String msg);
	public void updateCouponIndex(String msg);
	public List<CpScrapy> getScrapyList();
	
	//public void insertSpiderStatus(SpiderStatusJson message) ;

}
