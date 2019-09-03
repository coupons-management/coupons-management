package com.gopher.system.model.vo.request;

import com.gopher.system.model.vo.PageRequestBase;

public class CpSitestorePageRequest extends PageRequestBase{
	private int siteId;
	private String name;
	private Integer level;
	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}
