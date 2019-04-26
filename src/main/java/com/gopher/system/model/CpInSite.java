package com.gopher.system.model;

/**
 * CpInSite entity. @author MyEclipse Persistence Tools
 */

public class CpInSite extends BaseModel{
	private static final long serialVersionUID = 1L;

	private String name;
	private String dsc;
	private String url;
	private String language;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDsc() {
		return this.dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}