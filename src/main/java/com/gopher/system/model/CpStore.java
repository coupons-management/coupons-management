package com.gopher.system.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家信息
 * CP_STORE
 * @author 
 */
public class CpStore implements Serializable {
    private Integer id;

    /**
     * 商家名称
     */
    private String name;

    /**
     * 商家网站
     */
    private String website;

    /**
     * 广告 网站地址
     */
    private String advertising;

    /**
     * 国家
     */
    private String country;

    /**
     * 商家名称CRC32
     */
    private String nameCrc;

    /**
     * 商家网站CRC32
     */
    private String websiteCrc;

    /**
     * 优惠券数量
     */
    private Integer couponCount;

    /**
     * 有效数量
     */
    private Integer couponCountValid;

    /**
     * 入库方式
     */
    private Integer inType;

    /**
     * 审核方式
     */
    private Integer approval;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String advertising) {
        this.advertising = advertising;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNameCrc() {
        return nameCrc;
    }

    public void setNameCrc(String nameCrc) {
        this.nameCrc = nameCrc;
    }

    public String getWebsiteCrc() {
        return websiteCrc;
    }

    public void setWebsiteCrc(String websiteCrc) {
        this.websiteCrc = websiteCrc;
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
    }

    public Integer getCouponCountValid() {
        return couponCountValid;
    }

    public void setCouponCountValid(Integer couponCountValid) {
        this.couponCountValid = couponCountValid;
    }

    public Integer getInType() {
        return inType;
    }

    public void setInType(Integer inType) {
        this.inType = inType;
    }

    public Integer getApproval() {
        return approval;
    }

    public void setApproval(Integer approval) {
        this.approval = approval;
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
        CpStore other = (CpStore) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getWebsite() == null ? other.getWebsite() == null : this.getWebsite().equals(other.getWebsite()))
            && (this.getAdvertising() == null ? other.getAdvertising() == null : this.getAdvertising().equals(other.getAdvertising()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getNameCrc() == null ? other.getNameCrc() == null : this.getNameCrc().equals(other.getNameCrc()))
            && (this.getWebsiteCrc() == null ? other.getWebsiteCrc() == null : this.getWebsiteCrc().equals(other.getWebsiteCrc()))
            && (this.getCouponCount() == null ? other.getCouponCount() == null : this.getCouponCount().equals(other.getCouponCount()))
            && (this.getCouponCountValid() == null ? other.getCouponCountValid() == null : this.getCouponCountValid().equals(other.getCouponCountValid()))
            && (this.getInType() == null ? other.getInType() == null : this.getInType().equals(other.getInType()))
            && (this.getApproval() == null ? other.getApproval() == null : this.getApproval().equals(other.getApproval()))
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getWebsite() == null) ? 0 : getWebsite().hashCode());
        result = prime * result + ((getAdvertising() == null) ? 0 : getAdvertising().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getNameCrc() == null) ? 0 : getNameCrc().hashCode());
        result = prime * result + ((getWebsiteCrc() == null) ? 0 : getWebsiteCrc().hashCode());
        result = prime * result + ((getCouponCount() == null) ? 0 : getCouponCount().hashCode());
        result = prime * result + ((getCouponCountValid() == null) ? 0 : getCouponCountValid().hashCode());
        result = prime * result + ((getInType() == null) ? 0 : getInType().hashCode());
        result = prime * result + ((getApproval() == null) ? 0 : getApproval().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", website=").append(website);
        sb.append(", advertising=").append(advertising);
        sb.append(", country=").append(country);
        sb.append(", nameCrc=").append(nameCrc);
        sb.append(", websiteCrc=").append(websiteCrc);
        sb.append(", couponCount=").append(couponCount);
        sb.append(", couponCountValid=").append(couponCountValid);
        sb.append(", inType=").append(inType);
        sb.append(", approval=").append(approval);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}