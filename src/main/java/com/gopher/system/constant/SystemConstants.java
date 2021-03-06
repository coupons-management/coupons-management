package com.gopher.system.constant;

import java.util.Objects;

public enum SystemConstants {
	
	IN_TEYE_MANUAL(1,"人工"),
	IN_TEYE_SPIDER(0,"爬虫"),
	
	EXPIRY_ALL(0,"全部"),
	EXPIRY_EXPERID(1,"已过期"),
	EXPIRY_NOT(2,"未过期"),
	
	SPIDER_TYPE_ALL(0,"全部"),
	SPIDER_TYPE_REQUIRED(1,"是"),
	SPIDER_TYPE_NOT_REQUIRED(2,"否"),
	
	DATE_RANGE_DAY(1,"日"),
	
	DATE_RANGE_WEEK(2,"周"),
	
	DATE_RANGE_MONTH(3,"月");
	
	
	private Integer value;
	private String description;
	
	 SystemConstants(Integer value, String description) {
		this.value = value;
		this.description = description;
	}
	public static String getDescription(Object value) {
		for (SystemConstants item : SystemConstants.values()) {
			if (Objects.equals(item.getValue(), value)) {
				return item.description;
			}
		}
		return "";
	}
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
