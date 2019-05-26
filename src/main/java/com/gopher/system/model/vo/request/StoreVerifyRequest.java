package com.gopher.system.model.vo.request;

import java.util.List;

public class StoreVerifyRequest {
	
	private List<Integer> validList;
	
	private List<Integer> invalidList;

	public List<Integer> getValidList() {
		return validList;
	}

	public void setValidList(List<Integer> validList) {
		this.validList = validList;
	}

	public List<Integer> getInvalidList() {
		return invalidList;
	}

	public void setInvalidList(List<Integer> invalidList) {
		this.invalidList = invalidList;
	}
	
	

}
