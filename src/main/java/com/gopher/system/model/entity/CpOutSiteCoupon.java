package com.gopher.system.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * cp_out_site_coupon
 * @author 
 */
public class CpOutSiteCoupon implements Serializable {
    private Integer id;

    /**
     * 优惠卷ID
     */
    private Integer couponId;

    /**
     * 站点ID
     */
    private Integer outSiteId;

    /**
     * 商家ID
     */
    private Integer storeId;

    /**
     * 标题
     */
    private String title;

    /**
     * 热门排序
     */
    private Integer hotSort;

    /**
     * 推荐排序
     */
    private Integer adviseSort;

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
    
    private String link;

    public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getOutSiteId() {
        return outSiteId;
    }

    public void setOutSiteId(Integer outSiteId) {
        this.outSiteId = outSiteId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        CpOutSiteCoupon other = (CpOutSiteCoupon) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
            && (this.getOutSiteId() == null ? other.getOutSiteId() == null : this.getOutSiteId().equals(other.getOutSiteId()))
            && (this.getStoreId() == null ? other.getStoreId() == null : this.getStoreId().equals(other.getStoreId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getHotSort() == null ? other.getHotSort() == null : this.getHotSort().equals(other.getHotSort()))
            && (this.getAdviseSort() == null ? other.getAdviseSort() == null : this.getAdviseSort().equals(other.getAdviseSort()))
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
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getOutSiteId() == null) ? 0 : getOutSiteId().hashCode());
        result = prime * result + ((getStoreId() == null) ? 0 : getStoreId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getHotSort() == null) ? 0 : getHotSort().hashCode());
        result = prime * result + ((getAdviseSort() == null) ? 0 : getAdviseSort().hashCode());
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
        sb.append(", couponId=").append(couponId);
        sb.append(", outSiteId=").append(outSiteId);
        sb.append(", storeId=").append(storeId);
        sb.append(", title=").append(title);
        sb.append(", hotSort=").append(hotSort);
        sb.append(", adviseSort=").append(adviseSort);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}