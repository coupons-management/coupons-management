package com.gopher.system.service;

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
	//void synInSiteData();
	/**
	 * 清除前一天数据
	 */
	void clearData();
	/**
	 * 同步爬虫
	 */
	void synTypeData();
	
	
	void initData();
	/**
	 * 启动爬虫
	 * @param scrapy
	 */
	void startScrapy(String scrapy);
	
	


}
