package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.vo.CpOutSiteStoreVo;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;

public interface ShowSiteTwoService {
	
	/**
	 * 查站点2中商家与站点关系
	 * @param siteStore
	 * @return
	 */
	List<CpOutSiteStoreVo> getTwoList(ShowSiteStoreRequest siteStore);
	
	/**
	 * 修改外站商家关系
	 * @param cpOutSiteStore
	 */
	void updateOutSiteStore(CpOutSiteStore cpOutSiteStore);
	

	/**
	 * 删除外站商家关系
	 * @param cpOutSiteStore
	 */
	void deleteOutSiteStore(CpOutSiteStore cpOutSiteStore);
	/**
	 * 查看优惠卷
	 * @return
	 */
    List<CpCoupon> getCouponList(CpOutSiteStore cpOutSiteStore);
    /**
	 * 查看新增的优惠卷
	 * @return
	 */
    List<CpCoupon> getNewCouponList(CpOutSiteStore cpOutSiteStore);
	
	
List<CpOutSite> getSiteList();
    void addStoreToSite(ShowSiteStoreRequest showSiteStoreRequest);
    
    void addStoreToSiteBatch(List<ShowSiteStoreRequest> showSiteStoreList);
    
    void deleteStoreInSite(ShowSiteStoreRequest showSiteStoreRequest);
}
