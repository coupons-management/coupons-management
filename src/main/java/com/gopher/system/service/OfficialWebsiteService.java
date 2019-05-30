package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.entity.CpStore;
import com.gopher.system.model.entity.CpType;
import com.gopher.system.model.vo.CpCouponVo;
import com.gopher.system.model.vo.CpStoreVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.CpSitestoreRequest;
import com.gopher.system.model.vo.request.CpTypePageRequest;
import com.gopher.system.model.vo.request.StorePageRequst;

public interface OfficialWebsiteService {
	/**
	 * 取得推荐的类型
	 * @return
	 */
	List<CpType> getCategoriesList();
	/**
	 * 分页查询优惠卷
	 * @return
	 */
	Page<CpCouponVo> getCouponPageList(CouponPageRequest quest);
	/**
	 * 分页查询类别
	 * @return
	 */
	Page<CpType> getCategoriesPageList(CpTypePageRequest quest);
	/**
	 * 分页查询商家
	 * @return
	 */
	Page<CpStoreVo> getStorePageList(StorePageRequst quest );
	/**
	 * 查询所有商家分类
	 * @return
	 */
	List<CpType> getAllCategoriesList();
	
	
	List<CpStoreVo> getTopStoreList(CpSitestoreRequest quest);
	
	List<CpCouponVo> getTopCouponList(CouponPageRequest quest);
	

}
