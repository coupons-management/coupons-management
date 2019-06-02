package com.gopher.system.service;

import java.util.List;

import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.vo.CpOutSiteCouponVo;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.CouponSortRequest;

public interface CpOutSiteCouponService {
	/**
	 * 修改热门排序
	 * @param cpSiteStore
	 */
	void updateHotSort(CpOutSiteCoupon cpOutSiteCoupon);
	/**
	 * 批量热门
	 * @param couponSortRequest
	 */
	void updateHotSort(CouponSortRequest couponSortRequest);
	/**
	 * 修改热门推荐
	 * @param cpSiteStore
	 */
	void updateAdviseSort(CpOutSiteCoupon cpOutSiteCoupon);
	/**
	 * 批量
	 * @param couponSortRequest
	 */
	void updateAdviseSort(CouponSortRequest couponSortRequest);
	/**
	 * 删除热门排序
	 * @param cpSiteStore
	 */
	void deleteHotSort(CpOutSiteCoupon cpOutSiteCoupon);
	/**
	 *  删除热门推荐
	 * @param cpSiteStore
	 */
	void deleteAdviseSort(CpOutSiteCoupon cpOutSiteCoupon);
	/**
	 * 查询热门优惠卷
	 * @param cpOutSiteCoupon
	 * @return
	 */
	Page<CpOutSiteCouponVo> getHotList(CouponPageRequest obj);
	/**
	 * 
	 * @param cpOutSiteCoupon
	 * @return推荐优惠卷查询
	 */
	Page<CpOutSiteCouponVo> getAdviseList(CouponPageRequest obj);
	
	/**
	 * 查询热门优惠卷前10
	 * @param cpOutSiteCoupon
	 * @return
	 */
	List<CpOutSiteCouponVo> getTopHotList(CpOutSiteCoupon obj);
	/**
	 * 
	 * @param cpOutSiteCoupon
	 * @return推荐优惠卷查询前10
	 */
	List<CpOutSiteCouponVo> getTopAdviseList(CpOutSiteCoupon obj);

}
