package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpSiteStore;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.StorePageRequst;
import com.gopher.system.model.vo.response.StoreResponse;

public interface StoreService {
	
	Page<StoreResponse> getPage(StorePageRequst storeRequest);
	
	void edit(CpStore cpStore);
	
	void addSite(List<CpSiteStore> siteStoreList);
	
	

}
