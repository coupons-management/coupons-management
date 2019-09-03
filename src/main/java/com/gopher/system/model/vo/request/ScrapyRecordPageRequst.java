package com.gopher.system.model.vo.request;

import com.gopher.system.model.vo.PageRequestBase;

public class ScrapyRecordPageRequst extends PageRequestBase {
  
	private Integer scrapyId;
	
	private String starTime;
	
	private String endTime;

    public Integer getScrapyId() {
      return scrapyId;
    }
  
    public void setScrapyId(Integer scrapyId) {
      this.scrapyId = scrapyId;
    }
  
    public String getStartTime() {
      return starTime;
    }
  
    public void setStartTime(String starTime) {
      this.starTime = starTime;
    }
  
    public String getEndTime() {
      return endTime;
    }
  
    public void setEndTime(String endTime) {
      this.endTime = endTime;
    }
	
}
