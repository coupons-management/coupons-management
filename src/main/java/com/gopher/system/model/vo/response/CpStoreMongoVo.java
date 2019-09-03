package com.gopher.system.model.vo.response;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "store")
public class CpStoreMongoVo {
    
    @Id
	private String objectId;

    private int id;
	
    private String name;
	
    private String final_website;
	
    private String logo_url;
	
    private String spider_name;
	
    private String coupon_count;

    private boolean sync_state;
	
    public String getObjectId() {
      return objectId;
    }
  
    public void setObjectId(String objectId) {
      this.objectId = objectId;
    }

    public int getId() {
      return id;
    }
    
    public void setId(int id) {
      this.id = id;
    }
    
    public String getName() {
      return name;
    }
    
    public void setName(String name) {
      this.name = name;
    }
    
    public String getFinal_website() {
      return final_website;
    }
    
    public void setFinal_website(String final_website) {
      this.final_website = final_website;
    }
  
    public String getLogo_url() {
      return logo_url;
    }
  
    public void setLogo_url(String logo_url) {
      this.logo_url = logo_url;
    }
  
    public String getSpider_name() {
      return spider_name;
    }
  
    public void setSpider_name(String spider_name) {
      this.spider_name = spider_name;
    }

    public String getCoupon_count() {
      return coupon_count;
    }

    public void setCoupon_count(String coupon_count) {
      this.coupon_count = coupon_count;
    }

    public boolean isSync_state() {
      return sync_state;
    }

    public void setSync_state(boolean sync_state) {
      this.sync_state = sync_state;
    }
    
}
