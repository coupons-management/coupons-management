package com.gopher.system.model.vo.request;

import java.util.List;

import com.gopher.system.model.vo.PageRequestBase;

public class StorePageRequst extends PageRequestBase{
	/**
	 * 爬虫站
	 */
	private Integer scrapyId;
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
	/**
	 * 根据爬虫ID 获取的商家id集合
	 */
	private List<Integer> storeIdList;
	
	public Integer getScrapyId() {
		return scrapyId;
	}
	public void setScrapyId(Integer scrapyId) {
		this.scrapyId = scrapyId;
	}
	public List<Integer> getStoreIdList() {
		return storeIdList;
	}
	public void setStoreIdList(List<Integer> storeIdList) {
		this.storeIdList = storeIdList;
	}
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
