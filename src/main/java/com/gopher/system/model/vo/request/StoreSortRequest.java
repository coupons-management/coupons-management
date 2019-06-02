package com.gopher.system.model.vo.request;

import java.util.List;

import com.gopher.system.model.entity.CpOutSiteStore;

public class StoreSortRequest {
	
	private int outId;
	
	private List<CpOutSiteStore> cpOutSiteStoreList;

	public int getOutId() {
		return outId;
	}

	public void setOutId(int outId) {
		this.outId = outId;
	}

	public List<CpOutSiteStore> getCpOutSiteStoreList() {
		return cpOutSiteStoreList;
	}

	public void setCpOutSiteStoreList(List<CpOutSiteStore> cpOutSiteStoreList) {
		this.cpOutSiteStoreList = cpOutSiteStoreList;
	}
	
	

}
