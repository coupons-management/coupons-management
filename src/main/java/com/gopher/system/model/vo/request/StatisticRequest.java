package com.gopher.system.model.vo.request;

import com.gopher.system.model.vo.PageRequestBase;

public class StatisticRequest extends PageRequestBase{
	private int spiderId;
	
	private long beginTime;
	
	private long endTime;
	/**
	 * 时间范围 
	 * @see com.gopher.system.constant.SystemConstants
	 */
	private int range;
	
	public int getSpiderId() {
		return spiderId;
	}
	public void setSpiderId(int spiderId) {
		this.spiderId = spiderId;
	}
	public long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	

}
