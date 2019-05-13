package com.gopher.system.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * cp_coupon
 * @author 
 */
public class CpCoupon implements Serializable {
    private Integer id;

    private Integer storeId;

    private Integer inSiteId;

    private String name;

    private String code;

    private Date expireAt;

    private String storeWebsiteCrc;

    private String storeNameCrc;

    private String isPass;

    private String finalWebsite;

    private String storeWebsite;

    private String link;

    private String outSiteId;

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

    public Integer getInSiteId() {
        return inSiteId;
    }

    public void setInSiteId(Integer inSiteId) {
        this.inSiteId = inSiteId;
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

    public String getOutSiteId() {
        return outSiteId;
    }

    public void setOutSiteId(String outSiteId) {
        this.outSiteId = outSiteId;
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
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CpCoupon other = (CpCoupon) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStoreId() == null ? other.getStoreId() == null : this.getStoreId().equals(other.getStoreId()))
            && (this.getInSiteId() == null ? other.getInSiteId() == null : this.getInSiteId().equals(other.getInSiteId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getExpireAt() == null ? other.getExpireAt() == null : this.getExpireAt().equals(other.getExpireAt()))
            && (this.getStoreWebsiteCrc() == null ? other.getStoreWebsiteCrc() == null : this.getStoreWebsiteCrc().equals(other.getStoreWebsiteCrc()))
            && (this.getStoreNameCrc() == null ? other.getStoreNameCrc() == null : this.getStoreNameCrc().equals(other.getStoreNameCrc()))
            && (this.getIsPass() == null ? other.getIsPass() == null : this.getIsPass().equals(other.getIsPass()))
            && (this.getFinalWebsite() == null ? other.getFinalWebsite() == null : this.getFinalWebsite().equals(other.getFinalWebsite()))
            && (this.getStoreWebsite() == null ? other.getStoreWebsite() == null : this.getStoreWebsite().equals(other.getStoreWebsite()))
            && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()))
            && (this.getOutSiteId() == null ? other.getOutSiteId() == null : this.getOutSiteId().equals(other.getOutSiteId()))
            && (this.getCouponType() == null ? other.getCouponType() == null : this.getCouponType().equals(other.getCouponType()))
            && (this.getInType() == null ? other.getInType() == null : this.getInType().equals(other.getInType()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getSiteUrl() == null ? other.getSiteUrl() == null : this.getSiteUrl().equals(other.getSiteUrl()))
            && (this.getStoreUrl() == null ? other.getStoreUrl() == null : this.getStoreUrl().equals(other.getStoreUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStoreId() == null) ? 0 : getStoreId().hashCode());
        result = prime * result + ((getInSiteId() == null) ? 0 : getInSiteId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getExpireAt() == null) ? 0 : getExpireAt().hashCode());
        result = prime * result + ((getStoreWebsiteCrc() == null) ? 0 : getStoreWebsiteCrc().hashCode());
        result = prime * result + ((getStoreNameCrc() == null) ? 0 : getStoreNameCrc().hashCode());
        result = prime * result + ((getIsPass() == null) ? 0 : getIsPass().hashCode());
        result = prime * result + ((getFinalWebsite() == null) ? 0 : getFinalWebsite().hashCode());
        result = prime * result + ((getStoreWebsite() == null) ? 0 : getStoreWebsite().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        result = prime * result + ((getOutSiteId() == null) ? 0 : getOutSiteId().hashCode());
        result = prime * result + ((getCouponType() == null) ? 0 : getCouponType().hashCode());
        result = prime * result + ((getInType() == null) ? 0 : getInType().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getSiteUrl() == null) ? 0 : getSiteUrl().hashCode());
        result = prime * result + ((getStoreUrl() == null) ? 0 : getStoreUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", storeId=").append(storeId);
        sb.append(", inSiteId=").append(inSiteId);
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