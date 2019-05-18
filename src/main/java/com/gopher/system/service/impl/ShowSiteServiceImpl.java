package com.gopher.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpOutSiteDAO;
import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.service.ShowSiteService;
/**
 * 展示站点接口(内站)
 * @author dongyangyang
 *
 */
@Service
public class ShowSiteServiceImpl implements ShowSiteService{
    @Autowired
    private CpOutSiteDAO cpOutSiteDAO;
	@Override
	public List<CpOutSite> getSiteList() {
		return cpOutSiteDAO.getList();
	}
	/**
	 * 将审核通过的商家添加到展示站点中
	 */
	@Override
	public void addStoreToSite(int siteId, int storeId) {
		//TODO 1.添加关系表cp_out_site_store
		//     2.基于这个商家的原始的分类，映射到当前站点的分类并且同步到新的关系表中cp_type_store
		//     3.将此商家下的所有优惠券关联到当前站点下
		
	}
	@Override
	public void deleteStoreInSite(int siteId, int storeId) {
		// TODO 1.删除关系cp_out_site_store
		//      2.删除当前商家下的优惠券和当前站点的关系cp_out_site_coupon
		
	}

}
