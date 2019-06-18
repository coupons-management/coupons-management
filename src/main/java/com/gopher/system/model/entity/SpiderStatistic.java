package com.gopher.system.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * spider_statistic
 * @author 
 */
public class SpiderStatistic implements Serializable {
    private Integer id;
    /**
     * 爬虫ID
     */
    private Integer spiderId;
    /**
     * 商家ID
     */
    private Integer storeId;

    /**
     * 是否是新增的商家 1=是 0=否
     */
    private Integer isNewStore;
    /**
     * 新增优惠券数量
     */
    private Integer incrementCoupon;
    /**
     * 有效优惠券数量
     */
    private Integer validCoupon;
    /**
     * 优惠券总量
     */
    private Integer totalCoupon;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpiderId() {
        return spiderId;
    }

    public void setSpiderId(Integer spiderId) {
        this.spiderId = spiderId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getIsNewStore() {
        return isNewStore;
    }

    public void setIsNewStore(Integer isNewStore) {
        this.isNewStore = isNewStore;
    }

    public Integer getIncrementCoupon() {
        return incrementCoupon;
    }

    public void setIncrementCoupon(Integer incrementCoupon) {
        this.incrementCoupon = incrementCoupon;
    }

    public Integer getValidCoupon() {
        return validCoupon;
    }

    public void setValidCoupon(Integer validCoupon) {
        this.validCoupon = validCoupon;
    }

    public Integer getTotalCoupon() {
        return totalCoupon;
    }

    public void setTotalCoupon(Integer totalCoupon) {
        this.totalCoupon = totalCoupon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        SpiderStatistic other = (SpiderStatistic) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpiderId() == null ? other.getSpiderId() == null : this.getSpiderId().equals(other.getSpiderId()))
            && (this.getStoreId() == null ? other.getStoreId() == null : this.getStoreId().equals(other.getStoreId()))
            && (this.getIsNewStore() == null ? other.getIsNewStore() == null : this.getIsNewStore().equals(other.getIsNewStore()))
            && (this.getIncrementCoupon() == null ? other.getIncrementCoupon() == null : this.getIncrementCoupon().equals(other.getIncrementCoupon()))
            && (this.getValidCoupon() == null ? other.getValidCoupon() == null : this.getValidCoupon().equals(other.getValidCoupon()))
            && (this.getTotalCoupon() == null ? other.getTotalCoupon() == null : this.getTotalCoupon().equals(other.getTotalCoupon()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpiderId() == null) ? 0 : getSpiderId().hashCode());
        result = prime * result + ((getStoreId() == null) ? 0 : getStoreId().hashCode());
        result = prime * result + ((getIsNewStore() == null) ? 0 : getIsNewStore().hashCode());
        result = prime * result + ((getIncrementCoupon() == null) ? 0 : getIncrementCoupon().hashCode());
        result = prime * result + ((getValidCoupon() == null) ? 0 : getValidCoupon().hashCode());
        result = prime * result + ((getTotalCoupon() == null) ? 0 : getTotalCoupon().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", spiderId=").append(spiderId);
        sb.append(", storeId=").append(storeId);
        sb.append(", isNewStore=").append(isNewStore);
        sb.append(", incrementCoupon=").append(incrementCoupon);
        sb.append(", validCoupon=").append(validCoupon);
        sb.append(", totalCoupon=").append(totalCoupon);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}