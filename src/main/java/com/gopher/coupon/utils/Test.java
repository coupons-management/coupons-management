package com.gopher.coupon.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		/*SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String begin=format.format(new Date());
		System.out.println(begin);
		
		 Calendar c = Calendar.getInstance();
	        c.setTime(new Date());
	        c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
	 
	        Date  tomorrow= c.getTime();
	        System.out.println(tomorrow);
	        
	        
	        Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date zero = calendar.getTime();
            
            System.out.println(format.format(zero));*/
		getDay(1);
	}
	
	static void getDay(int i){
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, i);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
    	SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(zero));
		
	}

}
