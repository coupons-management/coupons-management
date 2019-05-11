package com.gopher.system.model.vo.request;

public class StorePageRequst extends PageRequestBase{
	/**
	 * 查询关键字
	 */
	private String search;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 爬虫分类
	 */
	private Integer scrapyType;
	/**
	 * 有效优惠券数量
	 */
	private Integer validCouponsCount;
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getScrapyType() {
		return scrapyType;
	}
	public void setScrapyType(Integer scrapyType) {
		this.scrapyType = scrapyType;
	}
	public Integer getValidCouponsCount() {
		return validCouponsCount;
	}
	public void setValidCouponsCount(Integer validCouponsCount) {
		this.validCouponsCount = validCouponsCount;
	}
	
	

}
