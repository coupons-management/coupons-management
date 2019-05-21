package com.gopher.system.worker;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.system.service.SynDataService;
import com.gopher.system.util.Test;
import com.gopher.system.util.TitleUtils;

public class SynBasicsData {
	@Autowired
	private SynDataService synDataService;
	
	
	@SuppressWarnings("unchecked")
	public void synDate(){
		//同步类型
		//synDataService.synTypeData();
		//同步商家
		//synDataService.synStoreData();
		//同步优惠卷
		synDataService.synCouponData();
		
		
		
    
	}
	
	 String getDay(int i){
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, i);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
    	SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(zero);
		
	}
	 @SuppressWarnings("unchecked")
		public void initData(){
			synDataService.initData();
			String messgae=initKeyWords();
			if(StringUtils.isEmpty(messgae))
			{
				return;
			}
			String[] messgaes=messgae.split(",",-1);
			for(String me:messgaes)
			{
				TitleUtils.keyWordsMap.put(me, me);
			}
			
		}
	 
	 //读取keyword消息
		 String initKeyWords(){
		     Properties properties = new Properties();
		     InputStream in = Test.class.getClassLoader().getResourceAsStream("keyword.properties");
		     try {
				properties.load(in);
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		     return properties.getProperty("keyword");
		}
		 
		 
			
			@SuppressWarnings("unchecked")
			public void clearDatd(){
				
				synDataService.clearData();
		    
			}
}
