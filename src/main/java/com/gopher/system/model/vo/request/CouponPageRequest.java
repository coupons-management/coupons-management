package com.gopher.system.model.vo.request;

import java.util.Date;

import com.gopher.system.model.vo.PageRequestBase;

public class CouponPageRequest extends PageRequestBase{
	
	/**
	 * 商家ID
	 */
	private Integer storeId;
	/**
	 * 过期时间
	 */
	private Date expiryTime;
	/**
	 * 爬虫站ID
	 */
	private Integer scrapy;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 标题
	 */
	private String name;
	/**
	 * 商家ID
	 */
	private Integer outSiteId;
	/**
	 * 优惠券类型
	 */
	private String type;
	/**
	 * 过期 0=全部,1=过期 2=未过期
	 */
	private int expired;
	
	private String  scrapyStr;
	
	private Date nowDate;

	public Integer getOutSiteId() {
		return outSiteId;
	}

	public void setOutSiteId(Integer outSiteId) {
		this.outSiteId = outSiteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNowDate() {
		return nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public Integer getScrapy() {
		return scrapy;
	}

	public void setScrapy(Integer scrapy) {
		this.scrapy = scrapy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getExpired() {
		return expired;
	}

	public void setExpired(int expired) {
		this.expired = expired;
	}

	public String getScrapyStr() {
		return scrapyStr;
	}

	public void setScrapyStr(String scrapyStr) {
		this.scrapyStr = scrapyStr;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}
    
}
