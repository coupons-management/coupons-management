package com.gopher.system.model.vo.response;

import com.gopher.system.model.vo.CpCouponVo;
import com.gopher.system.model.vo.Page;

public class StoreDetailResponse {

	private int id;

    private String name;

    private String description;

    private String logo;

    private String website;

    private String keyWords;

    private String title;

    private String storeDescription;

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStoreDescription() {
		return storeDescription;
	}

	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
	}

	private Page<CpCouponVo> couponList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
