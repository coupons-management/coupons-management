package com.gopher.system.model.vo.request;

import com.gopher.system.model.vo.PageRequestBase;

public class ShowSiteStoreRequest extends PageRequestBase {
	private int siteId;
	
	private int storeId;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 站点分类
	 */
	private String siteType;
	/**
	 * 国家
	 */
	private String storeType;
	
	/**
	 * 标签
	 */
	private String mark;
	/**
	 * 有效优惠券范围
	 */
	private int range;

	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 关键字
	 */
	private String key;
	/**
	 * 商家名称
	 */
	private String name;
	/**
	 * 官网
	 */
	private String web;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	


	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	

}
