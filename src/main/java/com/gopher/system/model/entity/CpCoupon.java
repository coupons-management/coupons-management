package com.gopher.system.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 优惠券
 * cp_coupon
 * 
 * @author
 */
public class CpCoupon implements Serializable {
	private Integer id;
	/**
	 * 商家ID
	 */
	private Integer storeId;
	/**
	 * 优惠券名称
	 */
	private String name;
	/**
	 * 
	 */
	private String code;
   
	private Date expireAt;
	
	private long expireAtTime;

	private String storeWebsiteCrc;

	private String storeNameCrc;
	/**
	 * 是否审核通过
	 */
	private String isPass;

	private String finalWebsite;

	private String storeWebsite;

	private String link;

	private Integer outSiteId;
	
	private Integer inSiteId;
	
	private String couponType;

	private String inType;

	/**
	 * 创建人
	 */
	private Integer createUser;

	/**
	 * 修改人
	 */
	private Integer updateUser;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date updateTime;

	private String siteUrl;

	private String storeUrl;

	private String scrapy;
	/**
	 * 标题
	 */
	private String title;

	/**
	 * 描述
	 */
	private String des;
	
	private Integer index;
	
	private int siteId;
	/**
	 * MANUAL_SORT
	 */
	private int manualSort;

	public int getManualSort() {
		return manualSort;
	}

	public void setManualSort(int manualSort) {
		this.manualSort = manualSort;
	}

	public long getExpireAtTime() {
		return expireAtTime;
	}

	public void setExpireAtTime(long expireAtTime) {
		this.expireAtTime = expireAtTime;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getScrapy() {
		return scrapy;
	}

	public void setScrapy(String scrapy) {
		this.scrapy = scrapy;
	}

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}

	public String getStoreWebsiteCrc() {
		return storeWebsiteCrc;
	}

	public void setStoreWebsiteCrc(String storeWebsiteCrc) {
		this.storeWebsiteCrc = storeWebsiteCrc;
	}

	public String getStoreNameCrc() {
		return storeNameCrc;
	}

	public void setStoreNameCrc(String storeNameCrc) {
		this.storeNameCrc = storeNameCrc;
	}

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	public String getFinalWebsite() {
		return finalWebsite;
	}

	public void setFinalWebsite(String finalWebsite) {
		this.finalWebsite = finalWebsite;
	}

	public String getStoreWebsite() {
		return storeWebsite;
	}

	public void setStoreWebsite(String storeWebsite) {
		this.storeWebsite = storeWebsite;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getOutSiteId() {
		return outSiteId;
	}

	public void setOutSiteId(Integer outSiteId) {
		this.outSiteId = outSiteId;
	}

	public Integer getInSiteId() {
		return inSiteId;
	}

	public void setInSiteId(Integer inSiteId) {
		this.inSiteId = inSiteId;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getInType() {
		return inType;
	}

	public void setInType(String inType) {
		this.inType = inType;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getStoreUrl() {
		return storeUrl;
	}

	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", storeId=").append(storeId);
		sb.append(", outSiteId=").append(outSiteId);
		sb.append(", name=").append(name);
		sb.append(", code=").append(code);
		sb.append(", expireAt=").append(expireAt);
		sb.append(", storeWebsiteCrc=").append(storeWebsiteCrc);
		sb.append(", storeNameCrc=").append(storeNameCrc);
		sb.append(", isPass=").append(isPass);
		sb.append(", finalWebsite=").append(finalWebsite);
		sb.append(", storeWebsite=").append(storeWebsite);
		sb.append(", link=").append(link);
		sb.append(", outSiteId=").append(outSiteId);
		sb.append(", couponType=").append(couponType);
		sb.append(", inType=").append(inType);
		sb.append(", createUser=").append(createUser);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", siteUrl=").append(siteUrl);
		sb.append(", storeUrl=").append(storeUrl);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}