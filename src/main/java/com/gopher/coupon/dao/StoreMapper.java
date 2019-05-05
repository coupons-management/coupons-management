package com.gopher.coupon.dao;

import java.util.List;

import com.gopher.coupon.utils.StoreJson;
import com.gopher.system.model.TMessageStore;

public interface StoreMapper {
	public List<TMessageStore> getStoreMessages() ;
	public List<TMessageStore> getCategoryMessages() ;
	public void insert(StoreJson json) ;
	void updateStoreMessageStatus(String id);
	public void delete(String id) ;
	
	
}
