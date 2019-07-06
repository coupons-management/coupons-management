package com.gopher.system.model.vo.request;

public class ShowSiteCouponRequest {
	
	private int id;
	
	private int mapId;
	/**
	 * 当前标题
	 */
	private String currentTitle;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 优惠码
	 */
	private String code;
	/**
	 * 过期时间
	 */
	private long expiryTime;
	/**
	 * 审核状态
	 */
	private String isPass;
	/**
	 * 商家ID
	 *
	 */
	private int storeId;
	

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public String getCurrentTitle() {
		return currentTitle;
	}

	public void setCurrentTitle(String currentTitle) {
		this.currentTitle = currentTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}
}
