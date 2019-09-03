package com.gopher.system.model.vo.response;

public class StatisticResponse {
	
	private String date;
	
	private int incrementStore;
	
	private int updateStore;
	
	private int incrementCoupon;
	
	private int validCoupon;
	
	private int totalCoupon;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIncrementStore() {
		return incrementStore;
	}

	public void setIncrementStore(int incrementStore) {
		this.incrementStore = incrementStore;
	}

	public int getUpdateStore() {
		return updateStore;
	}

	public void setUpdateStore(int updateStore) {
		this.updateStore = updateStore;
	}

	public int getIncrementCoupon() {
		return incrementCoupon;
	}

	public void setIncrementCoupon(int incrementCoupon) {
		this.incrementCoupon = incrementCoupon;
	}

	public int getValidCoupon() {
		return validCoupon;
	}

	public void setValidCoupon(int validCoupon) {
		this.validCoupon = validCoupon;
	}

	public int getTotalCoupon() {
		return totalCoupon;
	}

	public void setTotalCoupon(int totalCoupon) {
		this.totalCoupon = totalCoupon;
	}

}
