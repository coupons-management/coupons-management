package com.gopher.system.model.vo.request;

import java.util.Date;

public class ShowSiteCouponRequest {
	
	private int id;
	
	private int mapId;
	
	private String currentTile;
	
	private String description;
	
	private String code;
	
	private Date expriyTime;
	
	private String isPass;

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
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

	public String getCurrentTile() {
		return currentTile;
	}

	public void setCurrentTile(String currentTile) {
		this.currentTile = currentTile;
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

	public Date getExpriyTime() {
		return expriyTime;
	}

	public void setExpriyTime(Date expriyTime) {
		this.expriyTime = expriyTime;
	}
	
	

}
