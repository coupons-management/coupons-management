package com.gopher.system.dao.mysql;

import com.gopher.system.model.vo.request.StatisticRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticDAO {
    /**
     * 某时间段内 有效优惠券
     * @return
     */
    int getCouponValidCount(StatisticRequest statisticRequest);

    /**
     * 某时间段 总优惠券数量
     * @return
     */
    int getCouponTotalCount(StatisticRequest statisticRequest);

    /**
     * 某时间段 新增优惠券量
     * @return
     */
    int getCouponIncrementCount(StatisticRequest statisticRequest);

    /**
     * 时间段 商家有更新得数量 时间段内有新增优惠券的商家数量,distinct storeId
     * @return
     */
    int getStoreUpdateCount(StatisticRequest statisticRequest);

    /**
     * 时间段 新增的商家数量
     * @return
     */
    int getStoreIncrementCount(StatisticRequest statisticRequest);

    /**
     * 获取有效优惠券数量 的商家数量
     * @return
     */
    int getValidCouponStoreCount(StatisticRequest statisticRequest);



    // =======================================官网下的统计====================================================


    /**
     * 某时间段内 有效优惠券
     * @return
     */
    int getCouponValidCountInsite(StatisticRequest statisticRequest);

    /**
     * 某时间段 总优惠券数量
     * @return
     */
    int getCouponTotalCountInsite(StatisticRequest statisticRequest);

    /**
     * 某时间段 新增优惠券量
     * @return
     */
    int getCouponIncrementCountInsite(StatisticRequest statisticRequest);

    /**
     * 时间段 商家有更新得数量 时间段内有新增优惠券的商家数量,distinct storeId
     * @return
     */
    int getStoreUpdateCountInsite(StatisticRequest statisticRequest);

    /**
     * 时间段 新增的商家数量
     * @return
     */
    int getStoreIncrementCountInsite(StatisticRequest statisticRequest);


}
