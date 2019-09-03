package com.gopher.system.model.vo.request;

import java.util.Date;

public class StatisticRequest {
	/**
	 * 爬虫id
	 */
	private int spiderId;
	/**
	 * 爬虫
	 */
	private String spider;
	/**
	 * 官网ID
	 */
	private int siteId;
	/**
	 * 开始时间
	 */
	private long beginTime;
	/**
	 * 结束时间
	 */
	private long endTime;
	/**
	 * 时间范围 
	 * @see com.gopher.system.constant.SystemConstants
	 */
	private int range;

	private Date beginDate;

	private Date endDate;
	/**
	 * 有效优惠券 起始数量
	 */
	private Integer validCountBegin;
	/**
	 * 有效优惠券
	 */
	private Integer validCountEnd;

	private Integer validCountEq;

	private Integer validCountGt;

	public Integer getValidCountBegin() {
		return validCountBegin;
	}

	public void setValidCountBegin(Integer validCountBegin) {
		this.validCountBegin = validCountBegin;
	}

	public Integer getValidCountEnd() {
		return validCountEnd;
	}

	public void setValidCountEnd(Integer validCountEnd) {
		this.validCountEnd = validCountEnd;
	}

	public Integer getValidCountEq() {
		return validCountEq;
	}

	public void setValidCountEq(Integer validCountEq) {
		this.validCountEq = validCountEq;
	}

	public Integer getValidCountGt() {
		return validCountGt;
	}

	public void setValidCountGt(Integer validCountGt) {
		this.validCountGt = validCountGt;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getSpider() {
		return spider;
	}

	public void setSpider(String spider) {
		this.spider = spider;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

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
