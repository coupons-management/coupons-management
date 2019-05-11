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
	 * 来源爬虫，该商家源自哪个爬虫
	 */
	private String site;
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

	
	
/*	{
		"category":"Outerwear",类别
		"country":"US",国家
		"coupon_count":"10",优惠卷数量
		"created_at":"2019-02-28 13:35:00",创建时间
		"description":"Get the very best in Eastern style for less at 9FUDA.",
		"final_website":"http://www.9fuda.com",
		"logo_url":"https://sgi.offerscdn.net/i/zdcs-merchants/06aat7p7zNJ2josNX6O7Xj2.h90.w170.flpad.v24.bffffff.jpg",
		"name":"9FUDA",
		"site":"offers",爬虫
		"title":"9FUDA",标题
		"type":"store",类型
		"url_name":"https://www.offers.com/9fuda/",
		"uuid":"a5303ab4-3b5d-11e9-a9e1-f40f241a9d6c",
		"website":"http://www.9fuda.com/"
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
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
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
