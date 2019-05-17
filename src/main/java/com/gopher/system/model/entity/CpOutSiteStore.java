package com.gopher.system.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * cp_out_site_store
 * @author 
 */
public class CpOutSiteStore implements Serializable {
    private Integer id;

    private Integer outId;

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

    private Integer storeCount;

    private Integer couponCount;

    private String adAddress;

    private String mark;

    private String isManual;

    private String title;

    private String keywords;

    private String des;

    private String showName;

    private String storeDes;

    private String headerDes;

    private Integer hotSort;

    private Integer adviseSort;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
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

    public Integer getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(Integer storeCount) {
        this.storeCount = storeCount;
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
    }

    public String getAdAddress() {
        return adAddress;
    }

    public void setAdAddress(String adAddress) {
        this.adAddress = adAddress;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getIsManual() {
        return isManual;
    }

    public void setIsManual(String isManual) {
        this.isManual = isManual;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getStoreDes() {
        return storeDes;
    }

    public void setStoreDes(String storeDes) {
        this.storeDes = storeDes;
    }

    public String getHeaderDes() {
        return headerDes;
    }

    public void setHeaderDes(String headerDes) {
        this.headerDes = headerDes;
    }

    public Integer getHotSort() {
        return hotSort;
    }

    public void setHotSort(Integer hotSort) {
        this.hotSort = hotSort;
    }

    public Integer getAdviseSort() {
        return adviseSort;
    }

    public void setAdviseSort(Integer adviseSort) {
        this.adviseSort = adviseSort;
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
        CpOutSiteStore other = (CpOutSiteStore) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOutId() == null ? other.getOutId() == null : this.getOutId().equals(other.getOutId()))
            && (this.getStoreId() == null ? other.getStoreId() == null : this.getStoreId().equals(other.getStoreId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStoreCount() == null ? other.getStoreCount() == null : this.getStoreCount().equals(other.getStoreCount()))
            && (this.getCouponCount() == null ? other.getCouponCount() == null : this.getCouponCount().equals(other.getCouponCount()))
            && (this.getAdAddress() == null ? other.getAdAddress() == null : this.getAdAddress().equals(other.getAdAddress()))
            && (this.getMark() == null ? other.getMark() == null : this.getMark().equals(other.getMark()))
            && (this.getIsManual() == null ? other.getIsManual() == null : this.getIsManual().equals(other.getIsManual()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getKeywords() == null ? other.getKeywords() == null : this.getKeywords().equals(other.getKeywords()))
            && (this.getDes() == null ? other.getDes() == null : this.getDes().equals(other.getDes()))
            && (this.getShowName() == null ? other.getShowName() == null : this.getShowName().equals(other.getShowName()))
            && (this.getStoreDes() == null ? other.getStoreDes() == null : this.getStoreDes().equals(other.getStoreDes()))
            && (this.getHeaderDes() == null ? other.getHeaderDes() == null : this.getHeaderDes().equals(other.getHeaderDes()))
            && (this.getHotSort() == null ? other.getHotSort() == null : this.getHotSort().equals(other.getHotSort()))
            && (this.getAdviseSort() == null ? other.getAdviseSort() == null : this.getAdviseSort().equals(other.getAdviseSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOutId() == null) ? 0 : getOutId().hashCode());
        result = prime * result + ((getStoreId() == null) ? 0 : getStoreId().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStoreCount() == null) ? 0 : getStoreCount().hashCode());
        result = prime * result + ((getCouponCount() == null) ? 0 : getCouponCount().hashCode());
        result = prime * result + ((getAdAddress() == null) ? 0 : getAdAddress().hashCode());
        result = prime * result + ((getMark() == null) ? 0 : getMark().hashCode());
        result = prime * result + ((getIsManual() == null) ? 0 : getIsManual().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getKeywords() == null) ? 0 : getKeywords().hashCode());
        result = prime * result + ((getDes() == null) ? 0 : getDes().hashCode());
        result = prime * result + ((getShowName() == null) ? 0 : getShowName().hashCode());
        result = prime * result + ((getStoreDes() == null) ? 0 : getStoreDes().hashCode());
        result = prime * result + ((getHeaderDes() == null) ? 0 : getHeaderDes().hashCode());
        result = prime * result + ((getHotSort() == null) ? 0 : getHotSort().hashCode());
        result = prime * result + ((getAdviseSort() == null) ? 0 : getAdviseSort().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", outId=").append(outId);
        sb.append(", storeId=").append(storeId);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", storeCount=").append(storeCount);
        sb.append(", couponCount=").append(couponCount);
        sb.append(", adAddress=").append(adAddress);
        sb.append(", mark=").append(mark);
        sb.append(", isManual=").append(isManual);
        sb.append(", title=").append(title);
        sb.append(", keywords=").append(keywords);
        sb.append(", des=").append(des);
        sb.append(", showName=").append(showName);
        sb.append(", storeDes=").append(storeDes);
        sb.append(", headerDes=").append(headerDes);
        sb.append(", hotSort=").append(hotSort);
        sb.append(", adviseSort=").append(adviseSort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}