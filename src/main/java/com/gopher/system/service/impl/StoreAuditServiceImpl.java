package com.gopher.system.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.model.vo.request.StoreSortRequest;
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
	public Page<CpOutSiteStore> getHotStoreList(ShowSiteStoreRequest request) {
		Page<CpOutSiteStore> result=new Page<CpOutSiteStore>();
		List<CpOutSiteStore> list=cpOutSiteStoreDAO.getHotStoreList(request);
		int  total=cpOutSiteStoreDAO.getHotStoreCount(request);
		result.setList(list);
		result.setTotalCount(total);
		return result;
		
	}

	@Override
	public Page<CpOutSiteStore> getAdviseStroreList(ShowSiteStoreRequest request) {
		Page<CpOutSiteStore> result=new Page<CpOutSiteStore>();
		List<CpOutSiteStore> list=cpOutSiteStoreDAO.getAdviseStroreList(request);
		int  total=cpOutSiteStoreDAO.getAdviseStroreCount(request);
		result.setList(list);
		result.setTotalCount(total);
		return result;
	}

	@Override
	public List<CpOutSiteStore> getTopHotStoreList(CpOutSiteStore cpOutSiteStore) {
		return cpOutSiteStoreDAO.getTopHotStoreList(cpOutSiteStore);
	}

	@Override
	public List<CpOutSiteStore> getTopAdviseStroreList(CpOutSiteStore cpOutSiteStore) {
		return cpOutSiteStoreDAO.getTopAdviseStroreList(cpOutSiteStore);
	}

	@Override
	public void updateHotSort(StoreSortRequest storeSortRequest) {
		
		if(null == storeSortRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final int outId = 		storeSortRequest.getOutId();
		if(outId <= 0) {
			throw new BusinessRuntimeException("展示站点Id不能为空");
		}
		cpOutSiteStoreDAO.clearHotSort(outId);
		List<CpOutSiteStore> cpOutSiteStoreList = storeSortRequest.getCpOutSiteStoreList();
		if(null == cpOutSiteStoreList) {
			throw new BusinessRuntimeException("参数不能为空");
		}
	    for (CpOutSiteStore cpOutSiteStore : cpOutSiteStoreList) {
			this.updateAdviseSort(cpOutSiteStore);
		}
		
	}

	@Override
	public void updateAdviseSort(StoreSortRequest storeSortRequest) {
		if(null == storeSortRequest) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		final int outId = 		storeSortRequest.getOutId();
		if(outId <= 0) {
			throw new BusinessRuntimeException("展示站点Id不能为空");
		}
		List<CpOutSiteStore> cpOutSiteStoreList = storeSortRequest.getCpOutSiteStoreList();
		if(null == cpOutSiteStoreList) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		cpOutSiteStoreDAO.clearAdviseSort(outId);
	    for (CpOutSiteStore cpOutSiteStore : cpOutSiteStoreList) {
			this.updateAdviseSort(cpOutSiteStore);
		}
		
	}

}
