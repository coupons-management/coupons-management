package com.gopher.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.gopher.system.constant.TemplateKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopher.system.constant.CodeAndMsg;
import com.gopher.system.constant.SystemConstants;
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
import com.gopher.system.service.ShowSiteService;
import com.gopher.system.util.TitleUtils;
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
		Integer siteTypeId = null;
		if(null != cpStore) {
			// 当前商家存在原始分类
			CpSitestoreTypeMap query = new CpSitestoreTypeMap();
			query.setOutSiteId(siteId);
			query.setSourceTypeId(cpStore.getTypeId());
			CpSitestoreTypeMap cpSitestoreTypeMap = cpSitestoreTypeMapDAO.getBySiteAndSourceType(query);
			if(null != cpSitestoreTypeMap) {
				siteTypeId = cpSitestoreTypeMap.getSiteTypeId();
			}
		}
        if(null != siteTypeId && siteTypeId > 0) {
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
		outSiteStore.setShowName(TitleUtils.getStoreMessage(TemplateKeys.STORE_SHOW_NAME));
		outSiteStore.setKeywords(TitleUtils.getStoreMessage(TemplateKeys.STORE_KEYWORD));
		outSiteStore.setStoreDes(TitleUtils.getStoreMessage(TemplateKeys.STORE_DES));
		outSiteStore.setDes(TitleUtils.getStoreMessage(TemplateKeys.STORE_DESCRIPTION));
		outSiteStore.setTitle(TitleUtils.getStoreMessage(TemplateKeys.STORE_TITLE));
		outSiteStore.setCreateTime(now);
		outSiteStore.setUpdateTime(now);
		cpOutSiteStoreDAO.insert(outSiteStore);
		// 找到当前商家下的所有优惠券列表 同步到这个站点下来
		CpCoupon query = new CpCoupon();
		query.setStoreId(storeId);
		List<CpCoupon> couponList = cpCouponDAO.getList(query);
		if(null != couponList) {
			for (CpCoupon cpCoupon : couponList) {
				if(Objects.equals(cpCoupon.getInType(),SystemConstants.IN_TEYE_MANUAL.getValue().toString())) {
					// 如果是人工添加的优惠券 那么就不用同步过去
					continue;
				}
				CpOutSiteCoupon coupon = new CpOutSiteCoupon();
				coupon.setCouponId(cpCoupon.getId());//优惠券ID
				coupon.setOutSiteId(siteId);//在展示站ID
				// 动态生成现标题
				coupon.setTitle(TitleUtils.getMessage(cpCoupon.getName()));
				coupon.setStoreId(storeId);
				coupon.setCreateTime(now);
				coupon.setUpdateTime(now);
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
		if(storeId <= 0) {
			throw new BusinessRuntimeException("商家ID不能为空");
		}
		if(siteId <= 0) {
			throw new BusinessRuntimeException("展示站点ID不能为空");
		}
		CpOutSiteCoupon cpOutSiteCoupon = new CpOutSiteCoupon();
		cpOutSiteCoupon.setStoreId(storeId);
		cpOutSiteCoupon.setOutSiteId(siteId);
		cpOutSiteCouponDAO.deleteByBean(cpOutSiteCoupon);
		
		CpOutSiteStore cpOutSiteStore = new CpOutSiteStore();
		cpOutSiteStore.setStoreId(storeId);
		cpOutSiteStore.setOutId(siteId);
		cpOutSiteStoreDAO.deleteByBean(cpOutSiteStore);

	}
	
	public List<CpSitestoreType> getSiteTypeBySite(int siteId){
		return null;
	}
	/**
	 * 获取在展示站所有商家
	 * @return
	 */
	@Override
	public List<CpOutSiteStore> getStoreListInShowSite(CpOutSiteStore cpOutSiteStore){
		if(cpOutSiteStore == null) {
			throw new BusinessRuntimeException("参数不能为空");
		}
		List<CpOutSiteStore> list = cpOutSiteStoreDAO.getList(cpOutSiteStore);
		return list;
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
