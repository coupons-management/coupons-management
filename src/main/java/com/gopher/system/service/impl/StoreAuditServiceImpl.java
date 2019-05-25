package com.gopher.system.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.service.StoreAuditService;
@Service
public class StoreAuditServiceImpl implements StoreAuditService {
	@Resource
	private CpOutSiteStoreDAO cpOutSiteStoreDAO;
	@Override
	public void addSite(CpOutSiteStore cpOutSiteStore) {
		cpOutSiteStore.setCreateTime(new Date());
		cpOutSiteStoreDAO.insert(cpOutSiteStore);

	}
	
	@Override
	public List<CpOutSiteStore> getOutSitleList(CpOutSiteStore cpOutSiteStore) {
		return cpOutSiteStoreDAO.getList(cpOutSiteStore);
	}

	@Override
	public void updateHotSort(CpOutSiteStore cpOutSiteStore) {
		cpOutSiteStore.setUpdateTime(new Date());
		cpOutSiteStoreDAO.updateHotSort(cpOutSiteStore);
		
	}

	@Override
	public void updateAdviseSort(CpOutSiteStore cpOutSiteStore) {
		cpOutSiteStore.setUpdateTime(new Date());
		cpOutSiteStoreDAO.updateAdviseSort(cpOutSiteStore);		
	}

	@Override
	public void deleteHotSort(CpOutSiteStore cpOutSiteStore) {
		cpOutSiteStore.setUpdateTime(new Date());
		cpOutSiteStore.setHotSort(0);
		cpOutSiteStoreDAO.updateHotSort(cpOutSiteStore);
		
	}

	@Override
	public void deleteAdviseSort(CpOutSiteStore cpOutSiteStore) {
		cpOutSiteStore.setUpdateTime(new Date());
		cpOutSiteStore.setAdviseSort(0);
		cpOutSiteStoreDAO.updateAdviseSort(cpOutSiteStore);		
		
	}

	@Override
	public List<CpOutSiteStore> getOutSitleHotList(CpOutSiteStore cpOutSiteStore) {
		// TODO Auto-generated method stub
		return cpOutSiteStoreDAO.getOutSitleHotList(cpOutSiteStore);		
	}

	@Override
	public List<CpOutSiteStore> getOutSitleAdviseList(CpOutSiteStore cpOutSiteStore) {
		// TODO Auto-generated method stub
		return cpOutSiteStoreDAO.getOutSitleAdviseList(cpOutSiteStore);
	}

}
