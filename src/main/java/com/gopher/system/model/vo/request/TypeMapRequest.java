package com.gopher.system.model.vo.request;

import java.util.List;

public class TypeMapRequest {
	
	private int siteTypeId;
	
	private List<Integer> sourceTypeIdList;

	public int getSiteTypeId() {
		return siteTypeId;
	}

	public void setSiteTypeId(int siteTypeId) {
		this.siteTypeId = siteTypeId;
	}

	public List<Integer> getSourceTypeIdList() {
		return sourceTypeIdList;
	}

	public void setSourceTypeIdList(List<Integer> sourceTypeIdList) {
		this.sourceTypeIdList = sourceTypeIdList;
	}
	

}
