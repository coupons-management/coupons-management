package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
/**
 *  在展示站点
 * @author dongyangyang
 *
 */
public interface ShowSiteService {
	
    List<CpOutSite> getSiteList();
    
    void addStoreToSite(ShowSiteStoreRequest showSiteStoreRequest);
    
    void addStoreToSiteBatch(List<ShowSiteStoreRequest> showSiteStoreList);
    
    void deleteStoreInSite(ShowSiteStoreRequest showSiteStoreRequest);

	List<CpOutSiteStore> getStoreListInShowSite(CpOutSiteStore cpOutSiteStore);
    
}
