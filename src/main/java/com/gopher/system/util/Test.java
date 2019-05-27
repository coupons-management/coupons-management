package com.gopher.system.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		//-------------
	
	}
	 public static String execCurl(String[] cmds){
	        ProcessBuilder process = new ProcessBuilder(cmds);
	        Process p;
	        try {
	            p = process.start();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
	            StringBuilder builder = new StringBuilder();
	            String line = null;
	            while ((line = reader.readLine()) != null) {
	                builder.append(line);
	                builder.append(System.getProperty("line.separator"));
	            }
	            return builder.toString();
	 
	        } catch (IOException e) {
	            System.out.print("error");
	            e.printStackTrace();
	        }
	        return null;
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

	
	static String initKeyWords(){
	       Properties properties = new Properties();
	     // 使用ClassLoader加载properties配置文件生成对应的输入流
	     InputStream in = Test.class.getClassLoader().getResourceAsStream("keyword.properties");
	    // 使用properties对象加载输入流
	     try {
			properties.load(in);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	     //获取key对应的value值
	     return properties.getProperty("keyword");
	}
}
