package com.gopher.system.model.vo.request;

import com.gopher.system.model.vo.PageRequestBase;

public class CategoryRequest extends PageRequestBase{
	/**
	 * 分类ID
	 */
	private int id;
	/**
	 * 展示站点ID 官网ID
	 */
	private int outId;
	/**
	 * 展示站点ID 官网ID 等同 outId
	 */
	private int siteId;
	/**
	 * 优惠券类型
	 */
	private String couponType;
	
	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOutId() {
		return outId;
	}

	public void setOutId(int outId) {
		this.outId = outId;
	}

}
