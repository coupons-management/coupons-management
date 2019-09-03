package com.gopher.system.util;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "store")
public class StoreJson {
  @Id
  private String objectId;

  private String id;
  /**
   * 类型标识
   */
  private String category;
  
  private String country;
  
  @Field("coupon_count")
  private String couponCount;
  
  @Field("created_at")
  private String createdAt;
  
  private String description;
  
  /**
   * 商家域名
   */
  @Field("final_website")
  private String finalWebsite;
  
  /**
   * 商家logo地址
   */
  @Field("logo_url")
  private String logoUrl;
  
  /**
   * 名称
   */
  private String name;
  
  /**
   * 来源爬虫
   */

  @Field("spider_name")
  private String spiderName;
  
  /**
   * 爬虫站
   */
  @Field("source_site")
  private String sourceSite;
  
  /**
   * 标题
   */
  private String title;

  /**
   * 类型标识
   */
  private String type;

  @Field("url_name")
  private String urlName;
  
  //private String uuid;
  /**
   * 商家原站点地址
   */
  private String website;

  public String getObjectId() {
    return objectId;
  }

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCouponCount() {
    return couponCount;
  }

  public void setCouponCount(String couponCount) {
    this.couponCount = couponCount;
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

  public String getFinalWebsite() {
    return finalWebsite;
  }

  public void setFinalWebsite(String finalWebsite) {
    this.finalWebsite = finalWebsite;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUrlName() {
    return urlName;
  }

  public void setUrlName(String urlName) {
    this.urlName = urlName;
  }

//  public String getUuid() {
//    return uuid;
//  }
//
//  public void setUuid(String uuid) {
//    this.uuid = uuid;
//  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

}
