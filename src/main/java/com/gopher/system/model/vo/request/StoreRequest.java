package com.gopher.system.model.vo.request;

import com.gopher.system.model.vo.PageRequestBase;

public class StoreRequest extends PageRequestBase{
	private int id;
	private int storeId;
	private int siteId;
	private String couponType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCouponType() {
		return couponType;
	}
	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}
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
    
	
}