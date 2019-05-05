package com.gopher.coupon.service;

public interface SynDataService {
	/**
	 * 同步商家
	 */
	void synStoreData();
	/**
	 * 同步优惠卷
	 */
	void synCouponData();
	/**
	 * 同步站点
	 */
	void synInSiteData();
	/**
	 * 同步爬虫
	 */
	void synScrapyData();


}
