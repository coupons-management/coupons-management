package com.gopher.system.model.vo.response;

import java.util.List;

public class SitestoreTypeTree {
	private Integer id;
	
	private String name;
	
	private Integer level;
	
	private Integer pid;
	
	private List<SitestoreTypeTree> childList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public List<SitestoreTypeTree> getChildList() {
		return childList;
	}

	public void setChildList(List<SitestoreTypeTree> childList) {
		this.childList = childList;
	}

}
