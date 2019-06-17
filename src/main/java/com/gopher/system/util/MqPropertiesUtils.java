package com.gopher.system.util;

import java.io.IOException;
import java.util.Properties;

public class MqPropertiesUtils {
  public static Properties pro=new Properties();
  static {
	  try {
		pro.load(MqPropertiesUtils.class.getClassLoader().getResourceAsStream("cp_config.properties"));
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
	public static void main(String[] args) {
		String borkUrl=(String) MqPropertiesUtils.pro.get("category_borkUrl");
		String userName=(String) MqPropertiesUtils.pro.get("category_userName");
		String password=(String) MqPropertiesUtils.pro.get("category_password");
		int port=Integer.parseInt( MqPropertiesUtils.pro.get("category_port").toString());
		String queue=(String) MqPropertiesUtils.pro.get("category_queue");
		String exchange=(String) MqPropertiesUtils.pro.get("category_exchange");
		String key=(String) MqPropertiesUtils.pro.get("category_key");
		System.out.println(borkUrl);
		System.out.println(userName);
		System.out.println(password);
		System.out.println(port);
		System.out.println(queue);
		System.out.println(exchange);
		System.out.println(key);

	}

}
