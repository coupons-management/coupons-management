package com.gopher.system.model.vo.response;

import java.util.ArrayList;
import java.util.List;

import com.gopher.system.model.entity.CpType;

public class TypeResponse {
	
	private List<CpType> manualList = new ArrayList<>();
	
	private List<CpType> spiderList = new ArrayList<>();

	public List<CpType> getManualList() {
		return manualList;
	}

	public void setManualList(List<CpType> manualList) {
		this.manualList = manualList;
	}

	public List<CpType> getSpiderList() {
		return spiderList;
	}

	public void setSpiderList(List<CpType> spiderList) {
		this.spiderList = spiderList;
	}
	
	

}
