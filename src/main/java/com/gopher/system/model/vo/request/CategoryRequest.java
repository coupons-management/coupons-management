package com.gopher.system.model.vo.request;

public class CategoryRequest {
	/**
	 * 分类ID
	 */
	private int id;
	/**
	 * 展示站点ID 官网ID
	 */
	private int outId;
	/**
	 * 展示站点ID 官网ID 等同 outId
	 */
	private int siteId;
	
	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOutId() {
		return outId;
	}

	public void setOutId(int outId) {
		this.outId = outId;
	}

}
