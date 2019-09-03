package com.gopher.system.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * CP_SCRAPY_RECODE
 * @author 
 */
public class CpScrapyRecode implements Serializable {
  
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 爬虫ID
     */
    private Integer scrapyId;

    /**
     * 爬虫开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 进程ID
     */
    private String process;
    
    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 爬取店铺数量
     */
    private Integer storeCnt;

    /**
     * 新建店铺数量
     */
    private Integer newStoreCnt;

    /**
     * 新建优惠券的店铺数量
     */
    private Integer newCStoreCnt;

    /**
     * 优惠券数量
     */
    private Integer couponCnt;

    /**
     * 优惠券数量
     */
    private Integer newCouponCnt;

    private String name;

    public Integer getId() {
      return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
  
    public Integer getScrapyId() {
        return scrapyId;
    }

    public void setScrapyId(Integer scrapyId) {
        this.scrapyId = scrapyId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public String getProcess() {
      return process;
    }
  
    public void setProcess(String process) {
        this.process = process;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStoreCnt() {
      return storeCnt;
    }

    public void setStoreCnt(Integer storeCnt) {
      this.storeCnt = storeCnt;
    }

    public Integer getNewStoreCnt() {
      return newStoreCnt;
    }

    public void setNewStoreCnt(Integer newStoreCnt) {
      this.newStoreCnt = newStoreCnt;
    }

    public Integer getNewCStoreCnt() {
      return newCStoreCnt;
    }

    public void setNewCStoreCnt(Integer newCStoreCnt) {
      this.newCStoreCnt = newCStoreCnt;
    }

    public Integer getCouponCnt() {
      return couponCnt;
    }

    public void setCouponCnt(Integer couponCnt) {
      this.couponCnt = couponCnt;
    }

    public Integer getNewCouponCnt() {
      return newCouponCnt;
    }

    public void setNewCouponCnt(Integer newCouponCnt) {
      this.newCouponCnt = newCouponCnt;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
    
}