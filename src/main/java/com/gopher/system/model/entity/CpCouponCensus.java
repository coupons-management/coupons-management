package com.gopher.system.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * CP_COUPON_CENSUS
 * @author 
 */
public class CpCouponCensus implements Serializable {
    private Integer id;

    /**
     * 爬虫名
     */
    private String scrapyName;

    /**
     * 爬虫名
     */
    private Integer scrapyId;

    /**
     * 排名
     */
    private Integer sort;

    /**
     * 爬取时间
     */
    private Date scrapyTime;

    /**
     * 优惠卷名称
     */
    private String couponName;

    /**
     * 优惠卷ID
     */
    private Integer couponId;

    /**
     * 优惠卷商家ID
     */
    private Integer storeId;

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

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScrapyName() {
        return scrapyName;
    }

    public void setScrapyName(String scrapyName) {
        this.scrapyName = scrapyName;
    }

    public Integer getScrapyId() {
        return scrapyId;
    }

    public void setScrapyId(Integer scrapyId) {
        this.scrapyId = scrapyId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getScrapyTime() {
        return scrapyTime;
    }

    public void setScrapyTime(Date scrapyTime) {
        this.scrapyTime = scrapyTime;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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
        CpCouponCensus other = (CpCouponCensus) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getScrapyName() == null ? other.getScrapyName() == null : this.getScrapyName().equals(other.getScrapyName()))
            && (this.getScrapyId() == null ? other.getScrapyId() == null : this.getScrapyId().equals(other.getScrapyId()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getScrapyTime() == null ? other.getScrapyTime() == null : this.getScrapyTime().equals(other.getScrapyTime()))
            && (this.getCouponName() == null ? other.getCouponName() == null : this.getCouponName().equals(other.getCouponName()))
            && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
            && (this.getStoreId() == null ? other.getStoreId() == null : this.getStoreId().equals(other.getStoreId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getScrapyName() == null) ? 0 : getScrapyName().hashCode());
        result = prime * result + ((getScrapyId() == null) ? 0 : getScrapyId().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getScrapyTime() == null) ? 0 : getScrapyTime().hashCode());
        result = prime * result + ((getCouponName() == null) ? 0 : getCouponName().hashCode());
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getStoreId() == null) ? 0 : getStoreId().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", scrapyName=").append(scrapyName);
        sb.append(", scrapyId=").append(scrapyId);
        sb.append(", sort=").append(sort);
        sb.append(", scrapyTime=").append(scrapyTime);
        sb.append(", couponName=").append(couponName);
        sb.append(", couponId=").append(couponId);
        sb.append(", storeId=").append(storeId);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}