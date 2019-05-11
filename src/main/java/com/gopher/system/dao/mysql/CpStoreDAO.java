package com.gopher.system.dao.mysql;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.CpStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;

/**
 * CpStoreDAO继承基类
 */
@Repository
public interface CpStoreDAO extends MyBatisBaseDao<CpStore, Integer> {
	public CpStore getBeanByWebSite(String website);

	Page<CpStore> getPage(StorePageRequst storePageRequest);
}