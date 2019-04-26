package com.gopher.system.model;

/**
 * CpScrapy entity. @author MyEclipse Persistence Tools
 */

public class CpScrapy extends BaseModel{
	private static final long serialVersionUID = 1L;

	private String outSiteId;
	private String name;
	private String enable;
	private String project;


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

	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

}