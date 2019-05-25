package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;

public interface ShowSiteTwoService {
List<CpOutSite> getSiteList();
    
    void addStoreToSite(ShowSiteStoreRequest showSiteStoreRequest);
    
    void addStoreToSiteBatch(List<ShowSiteStoreRequest> showSiteStoreList);
    
    void deleteStoreInSite(ShowSiteStoreRequest showSiteStoreRequest);
}
