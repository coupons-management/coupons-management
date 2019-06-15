package com.gopher.system.worker.vo;

import java.util.Date;

public class SpiderStatisticVO {
	
	private Date beginTime;
	
	private Date endTime;
	/**
	 * 爬虫站点Id
	 */
	private int spiderId;
	/**
	 * 商家Id
	 */
	private int storeId;
	/**
	 * 有效优惠券
	 */
	private Date expiryTime;

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getSpiderId() {
		return spiderId;
	}
	public void setSpiderId(int spiderId) {
		this.spiderId = spiderId;
	}
	
	

}
