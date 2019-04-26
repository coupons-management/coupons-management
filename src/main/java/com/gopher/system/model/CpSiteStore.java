package com.gopher.system.model;

/**
 * CpSiteStore entity. @author MyEclipse Persistence Tools
 */

public class CpSiteStore extends BaseModel{
	private static final long serialVersionUID = 1L;

	private String inSiteId;
	private String storeId;


	public String getInSiteId() {
		return this.inSiteId;
	}

	public void setInSiteId(String inSiteId) {
		this.inSiteId = inSiteId;
	}

	public String getStoreId() {
		return this.storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}


}