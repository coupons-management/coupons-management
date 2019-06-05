package com.gopher.system.dao.mysql;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gopher.system.model.entity.CpOutSiteCoupon;
import com.gopher.system.model.vo.CpCouponVo;
import com.gopher.system.model.vo.CpOutSiteCouponVo;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.ShowSiteCouponPageRequest;
import com.gopher.system.model.vo.response.ShowSiteCouponResponse;

/**
 * CpOutSiteCouponDAO继承基类
 */
@Repository
public interface CpOutSiteCouponDAO extends MyBatisBaseDao<CpOutSiteCoupon, Integer> {
	
	/**
	 * 修改热门排序
	 * @param cpSiteStore
	 */
	void updateHotSort(CpOutSiteCoupon cpOutSiteCoupon);
	/**
	 * 修改热门推荐
	 * @param cpSiteStore
	 */
	void updateAdviseSort(CpOutSiteCoupon cpOutSiteCoupon);

	/**
	 * 查询热门优惠卷
	 * @param cpOutSiteCoupon
	 * @return
	 */
	List<CpOutSiteCouponVo> getHotList(CouponPageRequest obj);
	int getHotCount(CouponPageRequest obj);
	/**
	 * 
	 * @param cpOutSiteCoupon
	 * @return推荐优惠卷查询
	 */
	List<CpOutSiteCouponVo> getAdviseList(CouponPageRequest obj);
	int getAdviseCount(CouponPageRequest obj);
	
	
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
	
	
	void deleteByBean(CpOutSiteCoupon cpOutSiteCoupon);
	/**
	 *     获取当前站点下的优惠券的分页列表
	 * @param showSiteCouponRequest
	 * @return
	 */
	List<ShowSiteCouponResponse> getPageList(ShowSiteCouponPageRequest showSiteCouponRequest);
	/**
	 * 获取总数
	 * @param showSiteCouponRequest
	 * @return
	 */
	int getTotalCount(ShowSiteCouponPageRequest showSiteCouponRequest);
	
	
	int clearHotSort(int outId);
	
	int clearAdviseSort(int outId);
	/**
	 * 根据商家ID 获取所有优惠券
	 * @param storeIdList
	 * @return
	 */
	List<CpCouponVo> getListByCategory(ShowSiteCouponPageRequest showSiteCouponPageRequest);
	
	int getCountByCategory(ShowSiteCouponPageRequest showSiteCouponPageRequest);
	
	
}