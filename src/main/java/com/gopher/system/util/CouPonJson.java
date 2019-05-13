package com.gopher.system.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class CouPonJson {
	private String id;
	/**
	 * 代码
	 */
	private String code;
	/**
	 * 优惠卷类型
	 */
	@JSONField(name = "coupon_type")
	private String couponType;
	/**
	 * 创建时间
	 */
	@JSONField(name = "created_at")
	private String createdAt;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 到期时间
	 */
	@JSONField(name = "expire_at")
	private String expireAt;
	
	private Timestamp  expire;
	
	/**
	 * 最终站点
	 */
	@JSONField(name = "final_website")
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
	 * 站点
	 */
	private String site;
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
	@JSONField(name = "store_category")
	private String storeCategory;
	/**
	 * 商家城市
	 */
	@JSONField(name = "store_country")
	private String storeCountry;
	/**
	 * 商家描述
	 */
	@JSONField(name = "store_description")
	private String storeDescription;
	/**
	 * 商家图片
	 */
	@JSONField(name = "store_picture")
	private String storePicture;
	/**
	 * 商家URL名
	 */
	@JSONField(name = "store_url_name")
	private String storeUrlName;
	/**
	 * 商家网站
	 */
	@JSONField(name = "store_website")
	private String storeWebsite;
	/**
	 * 类型
	 */
	private String type;

	private String uuid;

	private String verify;
	
	    
	   /* 
	    {
	        "code":"",
	        "coupon_type":"DEAL",
	        "created_at":"2019-02-28 13:17:38",
	        "description":"",
	        "expire_at":"2099-12-30 00:00:00+00",
	        "final_website":"https://www.ywampublishing.com",
	        "link":"https://www.offers.com/exit/outbound/offer_id/4549173/ld/offerstrip/c/merchant/a/index/vb/1626718628582131024/",
	        "name":"Up to 45% off Kids' Mission Books",
	        "site":"offers",
	        "status":"0",
	        "store":"YWAM Publishing",
	        "store_category":"Books",
	        "store_country":"US",
	        "store_description":"Get Christian themed books at affordable prices on YWAM Publishing.",
	        "store_picture":"https://sgi.offerscdn.net/i/zdcs-merchants/032eAGBjVvfL3vTNcof5N4k.h90.w170.flpad.v16.bffffff.png",
	        "store_url_name":"https://www.offers.com/ywam-publishing/",
	        "store_website":"https://www.ywampublishing.com/default.aspx",
	        "type":"coupon_spider",
	        "uuid":"38718368-3b5b-11e9-b459-f40f241a9d6c",
	        "verify":"Y"
	    }*/

		public Timestamp  getExpire() {
			//this.expire=Timestamp.parse(createdAt); 
			this.expire = Timestamp.valueOf(createdAt);
		return expire;
	}

	public void setExpire(Timestamp  expire) {
		
		this.expire = Timestamp.valueOf(createdAt);
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

		public String getSite() {
			return site;
		}

		public void setSite(String site) {
			this.site = site;
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

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public String getVerify() {
			return verify;
		}

		public void setVerify(String verify) {
			this.verify = verify;
		}
	    
		Date getDate(String dateStr){
	        Date date = new Date();  
	        //注意format的格式要与日期String的格式相匹配  
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
