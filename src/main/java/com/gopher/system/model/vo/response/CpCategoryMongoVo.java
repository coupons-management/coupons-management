package com.gopher.system.model.vo.response;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
public class CpCategoryMongoVo {
    
    @Id
	private String objectId;

    private int id;
	
    private String name;
    
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

    public boolean isSync_state() {
      return sync_state;
    }

    public void setSync_state(boolean sync_state) {
      this.sync_state = sync_state;
    }
    
}
