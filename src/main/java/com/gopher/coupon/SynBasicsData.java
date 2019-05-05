package com.gopher.coupon;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.gopher.coupon.service.SynDataService;

public class SynBasicsData {
	@Autowired
	private SynDataService synDataService;
	
	
	@SuppressWarnings("unchecked")
	public void synDate(){
		//同步商家
		synDataService.synStoreData();
		//同步优惠卷
		synDataService.synCouponData();
		//同步站点
		//synDataService.synInSiteData();
		//同步爬虫
		synDataService.synScrapyData();
    
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
	public void test2(){
		System.out.println("============================");
	}
}