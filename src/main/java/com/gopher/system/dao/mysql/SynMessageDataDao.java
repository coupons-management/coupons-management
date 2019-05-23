package com.gopher.system.dao.mysql;

import java.util.List;

import com.gopher.system.model.entity.CpType;
import com.gopher.system.model.entity.TMessage;


public interface SynMessageDataDao {
	public List<TMessage> getCouPonMessages() ;
	public List<TMessage> getScrapyeMessages();
	public List<TMessage> getStoreMessages() ;
	public void insertStoreMessages(TMessage message) ;
	public void insertCouponMessages(TMessage message) ;
	public void insertScrapyeMessages(TMessage message) ;
	
/*	public void insertScrapye(CateGoryJson json) ;
	public void insertStoreByMessage(StoreJson json) ;*/

	//修改类型消息状态
	public int updateCategoryMessageStatus(String id);
	//修改优惠卷消息状态
	public int updateCouPonMessageStatus(String id);
	//修改商家消息状态
	public int updateStoreMessageStatus(String id);
	public void insertType(CpType json) ;
	//删除前一天已处理的优惠卷消息
	public void deleteCouPonMessages() ;
	//删除前一天已处理的商家消息;
	public void deleteStoreMessage() ;
	//删除前一天已处理的商家类型;
	public int deleteCategoryMessage() ;
	
	
	
	
}

