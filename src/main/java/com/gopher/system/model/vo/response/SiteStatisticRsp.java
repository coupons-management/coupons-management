package com.gopher.system.model.vo.response;

/**
 * 站点统计
 */
public class SiteStatisticRsp {

    private int siteId;
    /**
     *  总的商家数量
     */
    private int storeNum;
    /**
     * 总的优惠券数量
     */
    private int couponNum;

    private int validCouponNum;

    private int codeCouponNum;

    private int dealCouponNum;

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(int storeNum) {
        this.storeNum = storeNum;
    }

    public int getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(int couponNum) {
        this.couponNum = couponNum;
    }

    public int getValidCouponNum() {
        return validCouponNum;
    }

    public void setValidCouponNum(int validCouponNum) {
        this.validCouponNum = validCouponNum;
    }

    public int getCodeCouponNum() {
        return codeCouponNum;
    }

    public void setCodeCouponNum(int codeCouponNum) {
        this.codeCouponNum = codeCouponNum;
    }

    public int getDealCouponNum() {
        return dealCouponNum;
    }

    public void setDealCouponNum(int dealCouponNum) {
        this.dealCouponNum = dealCouponNum;
    }
}
