package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpOutSite;
/**
 *  在展示站点
 * @author dongyangyang
 *
 */
public interface ShowSiteService {
	
    List<CpOutSite> getSiteList();
    
    void addStoreToSite(final int siteId ,final int storeId);
    
    void deleteStoreInSite(final int siteId,final int storeId);
    
}