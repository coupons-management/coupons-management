package com.gopher.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpSiteStore;
import com.gopher.system.service.StoreAuditService;

public class StoreAuditServiceImpl implements StoreAuditService {
	@Resource
	private CpOutSiteStoreDAO cpOutSiteStoreDAO;
	@Override
	public void addSite(CpOutSiteStore cpOutSiteStore) {
		cpOutSiteStoreDAO.insert(cpOutSiteStore);

	}
	
	@Override
	public List<CpOutSiteStore> getOutSitleList(CpOutSiteStore cpOutSiteStore) {
		return cpOutSiteStoreDAO.getList(cpOutSiteStore);
	}

}
