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
