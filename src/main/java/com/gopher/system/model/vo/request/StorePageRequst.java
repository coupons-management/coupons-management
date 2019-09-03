package com.gopher.system.model.vo.request;

import java.util.Date;
import java.util.List;

import com.gopher.system.model.vo.PageRequestBase;

public class StorePageRequst extends PageRequestBase{
	/**
	 * 爬虫站
	 */
	private Integer scrapyId;
	/**
	 * 查询关键字
	 */
	private String search;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 国家
	 */
	private String name;
	/**
	 * 爬虫分类
	 */
	private Integer scrapyType;
	/**
	 * 有效优惠券数量
	 */
	private Integer validCouponsCount;
	/**
	 * 排除的商家列表
	 */
	private List<Integer> excludeStoreIdList;
	
	//======================商家审核的一些参数===========================
	/**
	 * 展示站点ID
	 */
	private Integer siteId;
	/**
	   * 审核状态
	 */
	private String approval;
	/**
	 * 信息是否完整
	 */
	private String isComplete;

	//======================维护操作的参数===========================

	private int spiderId;

	private long beginTime;

	private long endTime;

	private Date beginDate;

	private Date endDate;
	/**
	 * 1= 有新增优惠券
	 * 2= 无新增优惠券
	 * 3= 新增的商家
	 */
	private int range;
	
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSiteId() {
		return siteId;
	}
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete;
	}
	public List<Integer> getExcludeStoreIdList() {
		return excludeStoreIdList;
	}
	public void setExcludeStoreIdList(List<Integer> excludeStoreIdList) {
		this.excludeStoreIdList = excludeStoreIdList;
	}
	public Integer getScrapyId() {
		return scrapyId;
	}
	public void setScrapyId(Integer scrapyId) {
		this.scrapyId = scrapyId;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getScrapyType() {
		return scrapyType;
	}
	public void setScrapyType(Integer scrapyType) {
		this.scrapyType = scrapyType;
	}
	public Integer getValidCouponsCount() {
		return validCouponsCount;
	}
	public void setValidCouponsCount(Integer validCouponsCount) {
		this.validCouponsCount = validCouponsCount;
	}

}
