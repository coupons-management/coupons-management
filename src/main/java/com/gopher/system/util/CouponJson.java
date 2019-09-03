package com.gopher.system.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "coupon")
public class CouponJson {
  @Id
  private String objectId;
  private String id;
  /**
   * 代码
   */
  private String code;
  /**
   * 优惠卷类型
   */
  @Field("coupon_type")
  private String couponType;

  /**
   * 创建时间
   */
  @Field("created_at")
  private String createdAt;
  
  /**
   * 描述
   */
  private String description;
  /**
   * 到期时间
   */
  @Field("expire_at")
  private String expireAt;

  private Timestamp expire;

  /**
   * 最终站点
   */
  @Field("final_website")
  private String finalWebsite;
  /**
   * 站点
   */
  private String link;
  /**
   * 名称
   */
  private String name;
  
  /**
   * 爬虫
   */
  @Field("spider_name")
  private String spiderName;
  
  /*
   * * 站点
   */
  @Field("source_site")
  private String sourceSite;

  /**
   * 状态
   */
  private String status;
  
  /**
   * 商家
   */
  private String store;
  
  /**
   * 商家类型
   */
  @Field("store_category")
  private String storeCategory;
  /**
   * 商家城市
   */
  @Field("store_country")
  private String storeCountry;
  /**
   * 商家描述
   */
  @Field("store_description")
  private String storeDescription;
  /**
   * 商家图片
   */
  @Field("store_picture")
  private String storePicture;
  /**
   * 商家URL名
   */
  @Field("store_url_name")
  private String storeUrlName;
  /**
   * 商家网站
   */
  @Field("store_website")
  private String storeWebsite;
  /**
   * 类型
   */
  private String type;

//  private String uuid;
  /**
   * 是优惠卷在商家页面的序列
   */
  private int index;

  private String verify;
  
  @Field("store_id")
  private Integer storeId;

  public String getObjectId() {
    return objectId;
  }

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public Timestamp getExpire() {
    // this.expire=Timestamp.parse(createdAt);
    if (StringUtils.isNotEmpty(expireAt)) {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      try {
        this.expire = new Timestamp(format.parse(expireAt).getTime());
        // this.expire = Timestamp.valueOf(expireAt);

      } catch (ParseException e) {

        e.printStackTrace();
      }

    }
    return expire;
  }

  public void setExpire(Timestamp expire) {

    this.expire = expire;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCouponType() {
    return couponType;
  }

  public void setCouponType(String couponType) {
    this.couponType = couponType;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getExpireAt() {
    return expireAt;
  }

  public void setExpireAt(String expireAt) {
    this.expireAt = expireAt;
  }

  public String getFinalWebsite() {
    return finalWebsite;
  }

  public void setFinalWebsite(String finalWebsite) {
    this.finalWebsite = finalWebsite;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



  public String getSpiderName() {
    return spiderName;
  }

  public void setSpiderName(String spiderName) {
    this.spiderName = spiderName;
  }

  public String getSourceSite() {
    return sourceSite;
  }

  public void setSourceSite(String sourceSite) {
    this.sourceSite = sourceSite;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStore() {
    return store;
  }

  public void setStore(String store) {
    this.store = store;
  }

  public String getStoreCategory() {
    return storeCategory;
  }

  public void setStoreCategory(String storeCategory) {
    this.storeCategory = storeCategory;
  }

  public String getStoreCountry() {
    return storeCountry;
  }

  public void setStoreCountry(String storeCountry) {
    this.storeCountry = storeCountry;
  }

  public String getStoreDescription() {
    return storeDescription;
  }

  public void setStoreDescription(String storeDescription) {
    this.storeDescription = storeDescription;
  }

  public String getStorePicture() {
    return storePicture;
  }

  public void setStorePicture(String storePicture) {
    this.storePicture = storePicture;
  }

  public String getStoreUrlName() {
    return storeUrlName;
  }

  public void setStoreUrlName(String storeUrlName) {
    this.storeUrlName = storeUrlName;
  }

  public String getStoreWebsite() {
    return storeWebsite;
  }

  public void setStoreWebsite(String storeWebsite) {
    this.storeWebsite = storeWebsite;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

//  public String getUuid() {
//    return uuid;
//  }
//
//  public void setUuid(String uuid) {
//    this.uuid = uuid;
//  }

  public String getVerify() {
    return verify;
  }

  public void setVerify(String verify) {
    this.verify = verify;
  }

  public Integer getStoreId() {
    return storeId;
  }
  
  public void setStoreId(Integer storeId) {
    this.storeId = storeId;
  }

  Date getDate(String dateStr) {
    Date date = new Date();
    // 注意format的格式要与日期String的格式相匹配
    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      date = sdf.parse(dateStr);
      return date;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
