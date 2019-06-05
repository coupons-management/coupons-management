package com.gopher.system.model.vo.response;

import java.util.List;

import com.gopher.system.model.vo.CpCouponVo;
import com.gopher.system.model.vo.Page;

public class StoreDetailResponse {
    private String name;
    private String description;
    private String logo;
    private String website;
    
    private Page<CpCouponVo> couponList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Page<CpCouponVo> getCouponList() {
		return couponList;
	}

	public void setCouponList(Page<CpCouponVo> couponList) {
		this.couponList = couponList;
	}
    
}
