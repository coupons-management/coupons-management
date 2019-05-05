package com.gopher.coupon.utils;

import com.alibaba.fastjson.annotation.JSONField;

public class CouPonJson {
	    private String id;
	    private String code;
	    @JSONField(name = "coupon_type")
	    private String couponType;
	    @JSONField(name = "created_at")
	    private String createdAt;

	    private String description;
	    @JSONField(name = "expire_at")
	    private String expireAt;
	    @JSONField(name = "final_website")
	    private String finalWebsite;

	    private String link;

	    private String name;

	    private String site;

	    private String status;

	    private String store;
	    @JSONField(name = "store_category")
	    private String storeCategory;
	    @JSONField(name = "store_country")
	    private String storeCountry;
	    @JSONField(name = "store_description")
	    private String storeDescription;
	    @JSONField(name = "store_picture")
	    private String storePicture;
	    @JSONField(name = "store_url_name")
	    private String storeUrlName;
	    @JSONField(name = "store_website")
	    private String storeWebsite;

	    private String type;

	    private String uuid;

	    private String verify;

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
	    
	    
}
