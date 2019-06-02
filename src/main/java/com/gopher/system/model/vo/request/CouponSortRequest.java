package com.gopher.system.model.vo.request;

import java.util.List;

import com.gopher.system.model.entity.CpOutSiteCoupon;

public class CouponSortRequest {
	private int outId;
	
	private List<CpOutSiteCoupon> cpOutSiteCouponList;

	public int getOutId() {
		return outId;
	}

	public void setOutId(int outId) {
		this.outId = outId;
	}

	public List<CpOutSiteCoupon> getCpOutSiteCouponList() {
		return cpOutSiteCouponList;
	}

	public void setCpOutSiteCouponList(List<CpOutSiteCoupon> cpOutSiteCouponList) {
		this.cpOutSiteCouponList = cpOutSiteCouponList;
	}
	
	

}
