package com.gopher.system.model.vo.response;

public class StoreStatisticRsp {

    private String date;

    private int Coupon0;
    private int Coupon1_3;
    private int Coupon3_5;
    private int Coupon_5;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCoupon0() {
        return Coupon0;
    }

    public void setCoupon0(int coupon0) {
        Coupon0 = coupon0;
    }

    public int getCoupon1_3() {
        return Coupon1_3;
    }

    public void setCoupon1_3(int coupon1_3) {
        Coupon1_3 = coupon1_3;
    }

    public int getCoupon3_5() {
        return Coupon3_5;
    }

    public void setCoupon3_5(int coupon3_5) {
        Coupon3_5 = coupon3_5;
    }

    public int getCoupon_5() {
        return Coupon_5;
    }

    public void setCoupon_5(int coupon_5) {
        Coupon_5 = coupon_5;
    }
}
