package com.gopher.system.model.vo.response;

public class CouponResultsOfScore {
	//a.COUPON_ID, a.SCRAPY_ID, a.SORT, b.WEIGHT
	private int couponId;
	private int scrapyId;
	private int sort;
	private int weight;
	
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public int getScrapyId() {
		return scrapyId;
	}
	public void setScrapyId(int scrapyId) {
		this.scrapyId = scrapyId;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
