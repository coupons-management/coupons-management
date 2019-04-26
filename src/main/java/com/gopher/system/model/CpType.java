package com.gopher.system.model;

/**
 * CpType entity. @author MyEclipse Persistence Tools
 */

public class CpType extends BaseModel{
	private static final long serialVersionUID = 1L;

	private String outSiteId;
	private String name;
	private String des;

	public String getOutSiteId() {
		return this.outSiteId;
	}

	public void setOutSiteId(String outSiteId) {
		this.outSiteId = outSiteId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}


}