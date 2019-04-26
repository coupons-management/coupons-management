package com.gopher.system.model;

/**
 * CpStoreType entity. @author MyEclipse Persistence Tools
 */

public class CpStoreType extends BaseModel{
	private static final long serialVersionUID = 1L;
	private String storeId;
	private String typeId;

	public String getStoreId() {
		return this.storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	

}