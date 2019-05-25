package com.gopher.system.model.vo.response;

import java.util.Date;

public class ShowSiteCouponResponse {
	private Integer id;
	
	private Integer mapId;
	/**
	 * 原标题
	 */
	private String sourceTile;
	/**
	 * 当前标题
	 */
	private String currentTitle;
	
	private String couponType;
	
	private String code;
	
	private String description;
	
	private String expired;
	
	private Date expiryTime;
	
	private String isPass;
	
	private String isPassDesc;
	
	private Date createTime;
	
	private Date joinTime;
	
	private String inType;
	
	private boolean isManual;
	

	public Integer getMapId() {
		return mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public String getInType() {
		return inType;
	}

	public void setInType(String inType) {
		this.inType = inType;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public boolean isManual() {
		return isManual;
	}

	public void setManual(boolean isManual) {
		this.isManual = isManual;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourceTile() {
		return sourceTile;
	}

	public void setSourceTile(String sourceTile) {
		this.sourceTile = sourceTile;
	}

	public String getCurrentTitle() {
		return currentTitle;
	}

	public void setCurrentTitle(String currentTitle) {
		this.currentTitle = currentTitle;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	public String getIsPassDesc() {
		return isPassDesc;
	}

	public void setIsPassDesc(String isPassDesc) {
		this.isPassDesc = isPassDesc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

}
