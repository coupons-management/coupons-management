package com.gopher.system.model.vo.response;

public class StatisticResponse {
	
	private String date;
	
	private int incrementStore;
	
	private int totalStore;
	
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

	public int getTotalStore() {
		return totalStore;
	}

	public void setTotalStore(int totalStore) {
		this.totalStore = totalStore;
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
