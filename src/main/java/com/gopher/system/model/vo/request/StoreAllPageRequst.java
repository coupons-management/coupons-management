package com.gopher.system.model.vo.request;

import com.gopher.system.model.vo.PageRequestBase;

public class StoreAllPageRequst extends PageRequestBase{
	private int id;
	private String name;
	private String website;
	private String logo;
	private String typeId;
	private String search;
	private String typeName;
	private String country;
	private int toalCount;
	private int validCount;
	private int scrapyId;
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getScrapyId() {
		return scrapyId;
	}
	public void setScrapyId(int scrapyId) {
		this.scrapyId = scrapyId;
	}
	private String proportion;
	
	public String getProportion() {
		return proportion;
	}
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
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
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getToalCount() {
		return toalCount;
	}
	public void setToalCount(int toalCount) {
		this.toalCount = toalCount;
	}
	public int getValidCount() {
		return validCount;
	}
	public void setValidCount(int validCount) {
		this.validCount = validCount;
	}
	
	
}
