package com.gopher.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpOutSiteCouponDAO;
import com.gopher.system.dao.mysql.CpOutSiteDAO;
import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;
import com.gopher.system.dao.mysql.CpTypeStoreDAO;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.entity.CpOutSiteStore;
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
    @Autowired
    private CpOutSiteStoreDAO cpOutSiteStoreDAO;
    @Autowired
    private CpTypeStoreDAO cpTypeStoreDAO;
    @Autowired
    private CpOutSiteCouponDAO cpOutSiteCouponDAO;
    @Autowired
    private CpCouponDAO cpCouponDAO;
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
		CpOutSiteStore outSiteStore = new CpOutSiteStore();
		final Date now = new Date();
		outSiteStore.setOutId(siteId);
		outSiteStore.setStoreId(storeId);
		outSiteStore.setCreateTime(now);
		outSiteStore.setUpdateTime(now);
		cpOutSiteStoreDAO.insert(outSiteStore);
		// 找到当前商家下的所有优惠券列表 同步到这个站点下来
		CpCoupon query = new CpCoupon();
		query.setStoreId(storeId);
		List<CpCoupon> couponList = cpCouponDAO.getList(query);
		if(null != couponList) {
			for (CpCoupon cpCoupon : couponList) {
				CpOutSiteCoupon coupon = new CpOutSiteCoupon();
				coupon.setCouponId(cpCoupon.getId());//优惠券ID
				coupon.setOutSiteId(siteId);//在展示站ID
				//TODO 生成对应站点的标题
				coupon.setTitle(cpCoupon.getTitle());
				coupon.setStoreId(storeId);
				cpOutSiteCouponDAO.insert(coupon);
			}
		}
	}
	@Override
	public void deleteStoreInSite(int siteId, int storeId) {
		// TODO 1.删除关系cp_out_site_store
		//      2.删除当前商家下的优惠券和当前站点的关系cp_out_site_coupon
		
	}

}
