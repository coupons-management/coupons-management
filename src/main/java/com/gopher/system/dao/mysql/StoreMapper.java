package com.gopher.system.dao.mysql;

import java.util.List;

import com.gopher.system.model.entity.TMessageStore;
import com.gopher.system.util.StoreJson;

public interface StoreMapper {
	public List<TMessageStore> getStoreMessages() ;
	public List<TMessageStore> getCategoryMessages() ;
	public void insert(StoreJson json) ;
	void updateStoreMessageStatus(String id);
	public void delete(String id) ;
	
	
}
