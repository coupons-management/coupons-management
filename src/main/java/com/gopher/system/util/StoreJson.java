package com.gopher.system.util;

import com.alibaba.fastjson.annotation.JSONField;


public class StoreJson {
	private String id;
	/**
	 * 类型标识
	 */
	@JSONField(name = "category")
	private String category;
	private String country;
    @JSONField(name = "coupon_count")
	private String couponCount;
    @JSONField(name = "created_at")
	private String createdAt;
	private String description;
	  /**
	   *  商家域名
	   */
    @JSONField(name = "final_website")
	private String finalWebsite;
    /**
         * 商家logo地址
     */
    @JSONField(name = "logo_url")
	private String logoUrl;
    /**
            * 名称
     */
	private String name;
	/**
	 * 来源爬虫
	 */
	
	 @JSONField(name = "spider_name")
	private String spiderName;
	 /**
		爬虫站
		 */
		
	 @JSONField(name = "source_site")
	private String sourceSite;
	/**
	 * 标题
	 */
	private String title;
	
	
	/**
	 * 类型标识
	 */
	private String type;
	
    @JSONField(name = "url_name")
	private String urlName;
	private String uuid;
	/**
	 * 商家原站点地址
	 */
	private String website;

	
	
	/*
	{
		"type":"store",类型
		"title":"FLUXMOB",标题
		"logo_url":"https://sgi.offerscdn.net/i/zdcs-merchants/04PtXMIruSkLWA3CIv8ffDD.h90.w170.flpad.v26.bffffff.png",
		"name":"FLUXMOB",
		"spider_name":"offer",爬虫
		"source_site":"https://www.offers.com/",爬虫站
		"url_name":"https://www.offers.com/fluxmob/",
		"description":"Charge on the go with FluxMob's range of portable charges.",描述
		"category":"Electronics Accessories",类别
		"website":"https://www.fluxmob.com/",
		"country":"US",
		"picture":{
		},
		"coupon_count":"15",优惠卷数量
		"created_at":"2019-05-23 13:46:46",创建时间
		"final_website":"https://www.fluxmob.com",//商家网站
		"uuid":"34ee5269-7d61-11e9-b983-124b7a0b6b46"
		}*/
	
	

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCouponCount() {
		return couponCount;
	}
	public void setCouponCount(String couponCount) {
		this.couponCount = couponCount;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFinalWebsite() {
		return finalWebsite;
	}
	public void setFinalWebsite(String finalWebsite) {
		this.finalWebsite = finalWebsite;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSpiderName() {
		return spiderName;
	}
	public void setSpiderName(String spiderName) {
		this.spiderName = spiderName;
	}
	public String getSourceSite() {
		return sourceSite;
	}
	public void setSourceSite(String sourceSite) {
		this.sourceSite = sourceSite;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

}
