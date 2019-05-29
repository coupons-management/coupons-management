package com.gopher.system.model.vo.request;

import com.gopher.system.model.vo.PageRequestBase;

public class ShowSiteCouponPageRequest extends PageRequestBase{
	private int siteId;
	
	private String search;
	
	private String couponType;
	
	private String expiry;
	
	private String cteateType;
	
	private String state;
	
	private int storeId;

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getCteateType() {
		return cteateType;
	}

	public void setCteateType(String cteateType) {
		this.cteateType = cteateType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

	

}
