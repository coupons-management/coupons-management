package com.gopher.system.model.vo.response;

import java.util.List;

/**
 * 商家返回信息
 * @author dongyangyang
 *
 */
public class StoreResponse {
	
	private Integer id;
	
	private String name;
	
	private String website;
	
	private String logo;
	
	private int siteUsedCount;
	
	private int scrapySiteCount;
	
	private String scrapyType;
	
	private String validCouponsCount;
	
	private String createTime;
	
	private String updateTime;
	
	private String couponUpdateTime;
	
	private List<String> showSiteNameList;
	
	private List<String> spiderSiteNameList;
	
	private String approval;
	
	private String country;
    
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public List<String> getShowSiteNameList() {
		return showSiteNameList;
	}

	public void setShowSiteNameList(List<String> showSiteNameList) {
		this.showSiteNameList = showSiteNameList;
	}

	public List<String> getSpiderSiteNameList() {
		return spiderSiteNameList;
	}

	public void setSpiderSiteNameList(List<String> spiderSiteNameList) {
		this.spiderSiteNameList = spiderSiteNameList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getSiteUsedCount() {
		return siteUsedCount;
	}

	public void setSiteUsedCount(int siteUsedCount) {
		this.siteUsedCount = siteUsedCount;
	}

	public int getScrapySiteCount() {
		return scrapySiteCount;
	}

	public void setScrapySiteCount(int scrapySiteCount) {
		this.scrapySiteCount = scrapySiteCount;
	}

	public String getScrapyType() {
		return scrapyType;
	}

	public void setScrapyType(String scrapyType) {
		this.scrapyType = scrapyType;
	}

	public String getValidCouponsCount() {
		return validCouponsCount;
	}

	public void setValidCouponsCount(String validCouponsCount) {
		this.validCouponsCount = validCouponsCount;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCouponUpdateTime() {
		return couponUpdateTime;
	}

	public void setCouponUpdateTime(String couponUpdateTime) {
		this.couponUpdateTime = couponUpdateTime;
	}
	
	

}
