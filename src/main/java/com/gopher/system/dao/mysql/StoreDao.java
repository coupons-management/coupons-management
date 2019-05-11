package com.gopher.system.dao.mysql;

import java.util.List;

import com.gopher.system.model.entity.TMessageStore;

public interface StoreDao {
	public List<TMessageStore> getStoreMessages() ;
}
