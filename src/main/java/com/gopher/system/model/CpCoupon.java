package com.gopher.system.model;

import java.util.Date;

/**
 * CpCoupon entity. @author MyEclipse Persistence Tools
 */

public class CpCoupon extends BaseModel{
	private static final long serialVersionUID = 1L;
	
	private String storeId;
	
	private String inSiteId;
	
	private String name;
	
	private String code;
	
	private Date expireAt;
	
	private String storeWebsiteCrc;
	
	private String storeNameCrc;
	
	private String isPass;
	
	private String finalWebsite;
	
	private String outSiteId;

	public String getStoreId() {
		return this.storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getInSiteId() {
		return this.inSiteId;
	}

	public void setInSiteId(String inSiteId) {
		this.inSiteId = inSiteId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStoreWebsiteCrc() {
		return this.storeWebsiteCrc;
	}

	public void setStoreWebsiteCrc(String storeWebsiteCrc) {
		this.storeWebsiteCrc = storeWebsiteCrc;
	}

	public String getStoreNameCrc() {
		return this.storeNameCrc;
	}

	public void setStoreNameCrc(String storeNameCrc) {
		this.storeNameCrc = storeNameCrc;
	}

	public String getIsPass() {
		return this.isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	public String getFinalWebsite() {
		return this.finalWebsite;
	}

	public void setFinalWebsite(String finalWebsite) {
		this.finalWebsite = finalWebsite;
	}

	public String getOutSiteId() {
		return this.outSiteId;
	}

	public void setOutSiteId(String outSiteId) {
		this.outSiteId = outSiteId;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}


}