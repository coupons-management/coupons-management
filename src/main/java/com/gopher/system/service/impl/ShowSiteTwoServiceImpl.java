package com.gopher.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.constant.CodeAndMsg;
import com.gopher.system.dao.mysql.CpCouponDAO;
import com.gopher.system.dao.mysql.CpOutSiteCouponDAO;
import com.gopher.system.dao.mysql.CpOutSiteDAO;
import com.gopher.system.dao.mysql.CpOutSiteStoreDAO;
import com.gopher.system.dao.mysql.CpSitestoreTypeMapDAO;
import com.gopher.system.dao.mysql.CpStoreDAO;
import com.gopher.system.dao.mysql.CpTypeStoreDAO;
import com.gopher.system.exception.BusinessRuntimeException;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpOutSite;
import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.entity.CpOutSiteStore;
import com.gopher.system.model.entity.CpSitestoreType;
import com.gopher.system.model.entity.CpSitestoreTypeMap;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.CpTypeStore;
import com.gopher.system.model.vo.request.ShowSiteStoreRequest;
import com.gopher.system.model.vo.response.StoreResponse;
import com.gopher.system.service.ShowSiteTwoService;
import com.gopher.system.util.TitleUtils;

public class ShowSiteTwoServiceImpl implements ShowSiteTwoService {
	    @Autowired
	    private CpOutSiteDAO cpOutSiteDAO;
	    @Autowired
	    private CpOutSiteStoreDAO cpOutSiteStoreDAO;
	    @Autowired
	    private CpTypeStoreDAO cpTypeStoreDAO;
	    @Autowired
	    private CpSitestoreTypeMapDAO cpSitestoreTypeMapDAO;
	    @Autowired
	    private CpOutSiteCouponDAO cpOutSiteCouponDAO;
	    @Autowired
	    private CpCouponDAO cpCouponDAO;
	    @Autowired
	    private CpStoreDAO cpStoreDAO;
		@Override
		public List<CpOutSite> getSiteList() {
			return cpOutSiteDAO.getList();
		}
		/**
		 * 将审核通过的商家添加到展示站点中
		 */
		@Override
		public void addStoreToSite(ShowSiteStoreRequest showSiteStoreRequest) {
			
			//TODO 1.添加关系表cp_out_site_store
			//     2.基于这个商家的原始的分类，映射到当前站点的分类并且同步到新的关系表中cp_type_store
			//     3.将此商家下的所有优惠券关联到当前站点下
			if(null == showSiteStoreRequest) {
				throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
			}
			final int storeId = showSiteStoreRequest.getStoreId();
			final int siteId  = showSiteStoreRequest.getSiteId();
			if(storeId<=0) {
				throw new BusinessRuntimeException("商家ID不能为空");
			}
			if(siteId<=0) {
				throw new BusinessRuntimeException("展示站点ID不能为空");
			}
			CpStore cpStore = cpStoreDAO.selectByPrimaryKey(storeId);
			int siteTypeId = 0;
			if(null != cpStore) {
				// 当前商家存在原始分类
				CpSitestoreTypeMap query = new CpSitestoreTypeMap();
				query.setOutSiteId(siteId);
				query.setSourceTypeId(cpStore.getTypeId());
				CpSitestoreTypeMap cpSitestoreTypeMap = cpSitestoreTypeMapDAO.getBySiteAndSourceType(query);
				siteTypeId = cpSitestoreTypeMap.getSiteTypeId();
			}
	        if(siteTypeId > 0) {
	        	//当前商家对应的展示站点分类ID
	        	CpTypeStore cpTypeStore = new CpTypeStore();
	        	cpTypeStore.setOutSiteId(siteId);
	        	cpTypeStore.setStoreId(storeId);
	        	cpTypeStore.setTypeId(siteTypeId);
	        	cpTypeStoreDAO.insert(cpTypeStore);
	        }
			CpOutSiteStore outSiteStore = new CpOutSiteStore();
			final Date now = new Date();
			outSiteStore.setOutId(siteId);
			outSiteStore.setStoreId(storeId);
			outSiteStore.setShowName(cpStore.getName());
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
					coupon.setTitle(TitleUtils.getMessage(cpCoupon.getTitle()));
					coupon.setTitle(cpCoupon.getTitle());
					coupon.setStoreId(storeId);
					cpOutSiteCouponDAO.insert(coupon);
				}
			}
		}
		@Override
		public void deleteStoreInSite(ShowSiteStoreRequest showSiteStoreRequest) {
			//      1.删除关系cp_out_site_store
			//      2.删除当前商家下的优惠券和当前站点的关系cp_out_site_coupon
			if(null == showSiteStoreRequest) {
				throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
			}
			final int storeId = showSiteStoreRequest.getStoreId();
			final int siteId  = showSiteStoreRequest.getSiteId();
			if(storeId<=0) {
				throw new BusinessRuntimeException("商家ID不能为空");
			}
			if(siteId<=0) {
				throw new BusinessRuntimeException("展示站点ID不能为空");
			}
			CpOutSiteCoupon cpOutSiteCoupon = new CpOutSiteCoupon();
			cpOutSiteCoupon.setStoreId(storeId);
			cpOutSiteCoupon.setOutSiteId(siteId);
			cpOutSiteCouponDAO.deleteByBean(cpOutSiteCoupon);
			
			CpOutSiteCoupon query = new CpOutSiteCoupon();
			query.setStoreId(storeId);
			query.setOutSiteId(siteId);
			cpOutSiteCouponDAO.deleteByBean(query);
			
		}
		
		public List<CpSitestoreType> getSiteTypeBySite(int siteId){
			return null;
		}
		/**
		 * 获取在展示站所有商家
		 * @return
		 */
		public List<StoreResponse> getStoreListInShowSite(){
			
			return null;
		}
		
		@Override
		public void addStoreToSiteBatch(List<ShowSiteStoreRequest> showSiteStoreList) {
			if(null == showSiteStoreList || showSiteStoreList.isEmpty()) {
				throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
			}
			for (ShowSiteStoreRequest showSiteStoreRequest : showSiteStoreList) {
				this.addStoreToSite(showSiteStoreRequest);
			}
			
		}

	}