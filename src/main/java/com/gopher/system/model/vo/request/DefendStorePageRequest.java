package com.gopher.system.model.vo.request;

import java.util.Date;

import com.gopher.system.model.vo.PageRequestBase;

public class DefendStorePageRequest extends PageRequestBase{
	
	private int spiderSiteId;
	
	private long beginTime;
	
	private long endTime;
	
	private Date beginDate;
	
	private Date endDate;
	/**
	 * 1=新增优惠券的商家
	 * 2=无新增优惠券的商家
	 * 3=新增的商家
	 */
	private int storeType;
	
	public int getSpiderSiteId() {
		return spiderSiteId;
	}
	public void setSpiderSiteId(int spiderSiteId) {
		this.spiderSiteId = spiderSiteId;
	}
	public long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getStoreType() {
		return storeType;
	}
	public void setStoreType(int storeType) {
		this.storeType = storeType;
	}
	
}
