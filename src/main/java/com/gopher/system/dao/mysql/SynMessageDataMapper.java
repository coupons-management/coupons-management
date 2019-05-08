package com.gopher.system.dao.mysql;

import java.util.List;

import com.gopher.system.model.CpType;
import com.gopher.system.model.TMessage;
import com.gopher.system.util.CateGoryJson;
import com.gopher.system.util.CouPonJson;
import com.gopher.system.util.StoreJson;


public interface SynMessageDataMapper {
	public List<TMessage> getCouPonMessages() ;
	public void insert(CouPonJson json) ;
	//public void delete(String id) ;
	public List<TMessage> getScrapyeMessages();
	public int updateScMessageStatus(String id);
	public int updateCouPonMessageStatus(String id);
	
	public void insertScrapye(CateGoryJson json) ;
	public void insertStoreByMessage(StoreJson json) ;
	public List<TMessage> getStoreMessages() ;
	
	public void insertType(CpType json) ;
	
	
	
	
	
}

