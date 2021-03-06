package com.gopher.system.service;

import java.util.List;
import com.gopher.system.model.entity.CpCoupon;
import com.gopher.system.model.vo.Page;
import com.gopher.system.model.vo.request.CouponPageRequest;
import com.gopher.system.model.vo.request.MannulSortRequest;
import com.gopher.system.model.vo.response.CouponResponse;

public interface CouponService {
    /**
     * 获取系统优惠券分页列表
     *
     * @param couponPageRequest
     * @return
     */
    Page<CouponResponse> getPage(final CouponPageRequest couponPageRequest);

    /**
     * 获取当前商家的所有优惠券数量
     *
     * @param storeId
     * @return
     */
    public int getTotalCountByStore(final int storeId);

    /**
     * 获取当前商家有效的优惠券数量
     *
     * @param storeId
     * @return
     */
    public int getValidCountByStore(final int storeId);

    /**
     * 根据商家获取当前商家下的所有优惠券
     *
     * @param storeId
     * @return
     */
    List<CouponResponse> getListByStore(final int storeId);

    /**
     * 根据优惠券ID查询优惠券详情
     *
     * @param couponId
     * @return
     */
    CpCoupon getCoupon(final int couponId);

    /**
     * 人工创建优惠券
     *
     * @param cpCoupon
     */
    void createCoupon(final CpCoupon cpCoupon);

    /**
     * 人工编辑优惠券
     *
     * @param cpCoupon
     */
    void editCoupon(final CpCoupon cpCoupon);

    /**
     * 删除优惠券
     *
     * @param couponId
     */
    void deleteCoupon(final int couponId);

    /**
     * 根据商家获取最新的优惠券
     *
     * @param storeId
     * @param isScrapy 是否只看爬虫方式，不含人工方式
     * @return
     */
    CpCoupon getNewOne(final int storeId, boolean isScrapy);

    /**
     * 更新优惠券排序
     * @param mannulSortRequest
     */
    void updateSort(MannulSortRequest mannulSortRequest);
}