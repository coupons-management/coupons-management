package com.gopher.system.model.vo.request;

import java.util.Date;

import com.gopher.system.model.vo.PageRequestBase;

public class CouponPageRequest extends PageRequestBase{
	
	private Integer storeId;
	
	private Date expiryTime;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}
    
}
