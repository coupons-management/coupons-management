package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.OutSitePageInfo;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.model.vo.response.OutSiteStoreRsp;

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

    OutSiteStoreRsp getStoreTemplate();

    /**
     * 保存 页面信息 aboutUs contactUs
     * @param cpOutSite
     */
    void saveSiteInfo(CpOutSite cpOutSite);

    /**
     * 查询页面信息
     * @param id
     * @return
     */
    CpOutSite findOne(int id);


    List<OutSitePageInfo> findPageInfoList(int outSiteId);

    void savePageInfo(OutSitePageInfo outSitePageInfo);
    
}
