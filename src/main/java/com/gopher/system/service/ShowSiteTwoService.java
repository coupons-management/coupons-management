package com.gopher.system.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.vo.CpOutSiteStoreVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;

public interface ShowSiteTwoService {
	
	/**
	 * 查站点2中商家与站点关系
	 * @param siteStore
	 * @return
	 */
	
	
	Page<CpOutSiteStoreVo> getTwoList(ShowSiteStoreRequest siteStore);
	
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
	Page<CpCoupon> getCouponList(ShowSiteStoreRequest request);
    /**
	 * 查看新增的优惠卷
	 * @return
	 */
	Page<CpCoupon> getNewCouponList(ShowSiteStoreRequest request);
	
/**
 * 商家分类
 * @param request
 * @return
 */
	public List<CpSitestoreType> getStoreSort(CpSitestoreRequest request);
		
	
	
List<CpOutSite> getSiteList();
    void addStoreToSite(ShowSiteStoreRequest showSiteStoreRequest);
    
    void addStoreToSiteBatch(List<ShowSiteStoreRequest> showSiteStoreList);
    
    void deleteStoreInSite(ShowSiteStoreRequest showSiteStoreRequest);
}
