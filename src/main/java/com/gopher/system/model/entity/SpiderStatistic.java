package com.gopher.system.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * SPIDER_STATISTIC
 * @author 
 */
public class SpiderStatistic implements Serializable {
    private Integer id;

    private Integer spiderId;

    private Integer incrementCoupon;

    private Integer incrementStore;

    private Integer totalCoupon;

    private Integer totalStore;

    private Integer validCoupon;

    private Integer validStore;

    private Date createTime;

    private Date updateTime;

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

    public Integer getIncrementCoupon() {
        return incrementCoupon;
    }

    public void setIncrementCoupon(Integer incrementCoupon) {
        this.incrementCoupon = incrementCoupon;
    }

    public Integer getIncrementStore() {
        return incrementStore;
    }

    public void setIncrementStore(Integer incrementStore) {
        this.incrementStore = incrementStore;
    }

    public Integer getTotalCoupon() {
        return totalCoupon;
    }

    public void setTotalCoupon(Integer totalCoupon) {
        this.totalCoupon = totalCoupon;
    }

    public Integer getTotalStore() {
        return totalStore;
    }

    public void setTotalStore(Integer totalStore) {
        this.totalStore = totalStore;
    }

    public Integer getValidCoupon() {
        return validCoupon;
    }

    public void setValidCoupon(Integer validCoupon) {
        this.validCoupon = validCoupon;
    }

    public Integer getValidStore() {
        return validStore;
    }

    public void setValidStore(Integer validStore) {
        this.validStore = validStore;
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
        SpiderStatistic other = (SpiderStatistic) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpiderId() == null ? other.getSpiderId() == null : this.getSpiderId().equals(other.getSpiderId()))
            && (this.getIncrementCoupon() == null ? other.getIncrementCoupon() == null : this.getIncrementCoupon().equals(other.getIncrementCoupon()))
            && (this.getIncrementStore() == null ? other.getIncrementStore() == null : this.getIncrementStore().equals(other.getIncrementStore()))
            && (this.getTotalCoupon() == null ? other.getTotalCoupon() == null : this.getTotalCoupon().equals(other.getTotalCoupon()))
            && (this.getTotalStore() == null ? other.getTotalStore() == null : this.getTotalStore().equals(other.getTotalStore()))
            && (this.getValidCoupon() == null ? other.getValidCoupon() == null : this.getValidCoupon().equals(other.getValidCoupon()))
            && (this.getValidStore() == null ? other.getValidStore() == null : this.getValidStore().equals(other.getValidStore()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpiderId() == null) ? 0 : getSpiderId().hashCode());
        result = prime * result + ((getIncrementCoupon() == null) ? 0 : getIncrementCoupon().hashCode());
        result = prime * result + ((getIncrementStore() == null) ? 0 : getIncrementStore().hashCode());
        result = prime * result + ((getTotalCoupon() == null) ? 0 : getTotalCoupon().hashCode());
        result = prime * result + ((getTotalStore() == null) ? 0 : getTotalStore().hashCode());
        result = prime * result + ((getValidCoupon() == null) ? 0 : getValidCoupon().hashCode());
        result = prime * result + ((getValidStore() == null) ? 0 : getValidStore().hashCode());
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
        sb.append(", spiderId=").append(spiderId);
        sb.append(", incrementCoupon=").append(incrementCoupon);
        sb.append(", incrementStore=").append(incrementStore);
        sb.append(", totalCoupon=").append(totalCoupon);
        sb.append(", totalStore=").append(totalStore);
        sb.append(", validCoupon=").append(validCoupon);
        sb.append(", validStore=").append(validStore);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}