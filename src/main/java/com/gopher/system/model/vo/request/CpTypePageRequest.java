package com.gopher.system.model.vo.request;

import com.gopher.system.model.vo.PageRequestBase;

public class CpTypePageRequest extends PageRequestBase{
	private int id;
	private String name;
	private boolean selected;
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
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
