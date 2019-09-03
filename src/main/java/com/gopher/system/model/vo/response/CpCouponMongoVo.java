package com.gopher.system.model.vo.response;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gopher.system.util.DateUtils;

@Document(collection = "coupon")
public class CpCouponMongoVo {
    
    @Id
    private String objectId;
    
	private int id;

	private String store;
	
	private String name;

	private String coupon_type;
	
	private String description;
	
	private String expire_at;
	
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
  
    public String getStore() {
      return store;
    }
  
    public void setStore(String store) {
      this.store = store;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getCoupon_type() {
      return coupon_type;
    }

    public void setCoupon_type(String coupon_type) {
      this.coupon_type = coupon_type;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getExpire_at() {
      return expire_at;
    }

    public void setExpire_at(String expire_at) {
      this.expire_at = expire_at;
    }

    public String isPast() {
      if(expire_at == null){
        return "否";
      }
      Date date = DateUtils.getDateTime(expire_at);
      if(date.after(new Date())){
        return "否";
      }
      return "是";
    }
    
    public boolean isSync_state() {
      return sync_state;
    }

    public void setSync_state(boolean sync_state) {
      this.sync_state = sync_state;
    }

}
