package com.gopher.system.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

public class SpiderStatusJson {
	private String spider;
	private String time;
	private String status;
	private Timestamp  endTime;
	
	public Timestamp getEndTime() {
		if(StringUtils.isNotEmpty(time))
		{
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				this.endTime=new Timestamp(format.parse(time).getTime()) ;
				//this.expire = Timestamp.valueOf(expireAt);
			
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
	
		}
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getSpider() {
		return spider;
	}
	public void setSpider(String spider) {
		this.spider = spider;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
