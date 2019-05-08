package com.gopher.system.util;

import com.alibaba.fastjson.annotation.JSONField;

public class CateGoryJson {
	private String id;
	private String description;
	@JSONField(name = "icon_code")
    private String iconCode;
	@JSONField(name = "icon_color")
    private String iconColor;
    private String name;

    private String site;

    private String status;

    private String type;
    @JSONField(name = "url_name")
    private String urlName;
    
 /*   {
        "description":"Stay stylish yet keep warm with deals on outerwear from New York & Company, Eddie Bauer, Bloomingdale's, Kohl's, Old Navy, and other top brands.",
        "icon_code":"icon-christmas-001",
        "icon_color":"primary",
        "name":"Women's Outerwear",
        "site":"offers",
        "status":"0",
        "type":"category",
        "url_name":"womens-coats-jackets"
    }*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIconCode() {
		return iconCode;
	}
	public void setIconCode(String iconCode) {
		this.iconCode = iconCode;
	}

	public String getIconColor() {
		return iconColor;
	}
	public void setIconColor(String iconColor) {
		this.iconColor = iconColor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
    
}
