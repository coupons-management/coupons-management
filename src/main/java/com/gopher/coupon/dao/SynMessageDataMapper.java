package com.gopher.coupon.dao;

import java.util.List;

import com.gopher.coupon.utils.CateGoryJson;
import com.gopher.coupon.utils.CouPonJson;
import com.gopher.system.model.TMessage;


public interface SynMessageDataMapper {
	public List<TMessage> getCouPonMessages() ;
	public void insert(CouPonJson json) ;
	//public void delete(String id) ;
	public List<TMessage> getScrapyeMessages();
	public int updateScMessageStatus(String id);
	public int updateCouPonMessageStatus(String id);
	
	public void insertScrapye(CateGoryJson json) ;
	
	
}

