package com.gopher.system.model;

import java.io.Serializable;

/**
 * T_CATEGORY
 * @author 
 */
public class TCategory implements Serializable {
    private Integer pkId;

    private String name;

    /**
     * 分类的类型 1为商家 ，2为优惠券
     */
    private Byte type;

    /**
     * 父级分类id 与pkid对应
     */
    private Integer pid;

    /**
     * 1为自动同步，2为手动维护
     */
    private Boolean syncType;

    private static final long serialVersionUID = 1L;

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Boolean getSyncType() {
        return syncType;
    }

    public void setSyncType(Boolean syncType) {
        this.syncType = syncType;
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
        TCategory other = (TCategory) that;
        return (this.getPkId() == null ? other.getPkId() == null : this.getPkId().equals(other.getPkId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getSyncType() == null ? other.getSyncType() == null : this.getSyncType().equals(other.getSyncType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkId() == null) ? 0 : getPkId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getSyncType() == null) ? 0 : getSyncType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", pid=").append(pid);
        sb.append(", syncType=").append(syncType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}