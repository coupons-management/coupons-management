package com.gopher.system.listener;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gopher.system.model.entity.TMessage;
import com.gopher.system.service.MessageDataService;
import com.gopher.system.util.JmsConsumer;
import com.gopher.system.util.MqPropertiesUtils;
import com.gopher.system.util.SpringContextUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * Application Lifecycle Listener implementation class MessageListener
 *
 */
@WebListener
public class MessageListener implements ServletContextListener {
	private Log logger=LogFactory.getLog(MessageListener.class);
	ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(5));

	/**
     * Default constructor. 
     */
    public MessageListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
     	//this.synCategory();
       // this.synStore();
       // this.synCoupon();

    }
    
    
    /**
     * 联接MQ，接收商家类型消息
     */
    public  void synCategory() {
    	MessageDataService messageDataService=(MessageDataService) SpringContextUtil.getBean("messageDataService");
		try {
			
			//JmsConsumer jmsConsumer=new JmsConsumer("18.234.205.204", "coupon", "Ppp12345", 5672,"online_category_queue","scrapy","category");
			String borkUrl=(String) MqPropertiesUtils.pro.get("category_borkUrl");
			String userName=(String) MqPropertiesUtils.pro.get("category_userName");
			String password=(String) MqPropertiesUtils.pro.get("category_password");
			int port=Integer.parseInt( MqPropertiesUtils.pro.get("category_port").toString());
			String queue=(String) MqPropertiesUtils.pro.get("category_queue");
			String exchange=(String) MqPropertiesUtils.pro.get("category_exchange");
			String key=(String) MqPropertiesUtils.pro.get("category_key");
			JmsConsumer jmsConsumer=new JmsConsumer(borkUrl, userName, password, port,queue,exchange,key);
			jmsConsumer.start();
			
			//定义消费者
	        DefaultConsumer consumer = new DefaultConsumer(jmsConsumer.getChannel()) {
	            @Override
	            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
	            	executor.execute(new Thread(new Runnable() {
				  
				 @Override 
				 public void run() {
					 String msg=null;
					try {
						msg = new String(body, "utf-8");
						TMessage message=new TMessage();
						message.setMessageBody(msg);
						
						messageDataService.insertCategoryMessages(message);
					} catch (UnsupportedEncodingException e) {
						logger.debug(e);
					}
		              
				 }}));
	               
	            }
	        };
	        //监听队列
	        jmsConsumer.getChannel().basicConsume(jmsConsumer.getQueue(),true,consumer);
	        
		} catch (Exception e) {
			//e.printStackTrace();
			logger.debug(e);
		}
	

	}
    
    
    public  void synCoupon() {
    	MessageDataService messageDataService=(MessageDataService) SpringContextUtil.getBean("messageDataService");
		try {
			String borkUrl=(String) MqPropertiesUtils.pro.get("coupon_borkUrl");
			String userName=(String) MqPropertiesUtils.pro.get("coupon_userName");
			String password=(String) MqPropertiesUtils.pro.get("coupon_password");
			int port=Integer.parseInt( MqPropertiesUtils.pro.get("coupon_port").toString());
			String queue=(String) MqPropertiesUtils.pro.get("coupon_queue");
			String exchange=(String) MqPropertiesUtils.pro.get("coupon_exchange");
			String key=(String) MqPropertiesUtils.pro.get("coupon_key");
			
			JmsConsumer jmsConsumer=new JmsConsumer(borkUrl, userName, password, port,queue,exchange,key);
			jmsConsumer.start();
			
			//定义消费者
	        DefaultConsumer consumer = new DefaultConsumer(jmsConsumer.getChannel()) {
	            @Override
	            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
	            	executor.execute(new Thread(new Runnable() {
				  
				 @Override 
				 public void run() {
					 String msg=null;
					try {
						msg = new String(body, "utf-8");
						TMessage message=new TMessage();
						message.setMessageBody(msg);
						messageDataService.insertCouponMessages(message);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		              
				 }}));
	               
	            }
	        };
	        //监听队列
	        jmsConsumer.getChannel().basicConsume(jmsConsumer.getQueue(),true,consumer);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}
    public  void synStore() {
    	MessageDataService messageDataService=(MessageDataService) SpringContextUtil.getBean("messageDataService");
		try {
			String borkUrl=(String) MqPropertiesUtils.pro.get("store_borkUrl");
			String userName=(String) MqPropertiesUtils.pro.get("store_userName");
			String password=(String) MqPropertiesUtils.pro.get("store_password");
			int port=Integer.parseInt( MqPropertiesUtils.pro.get("store_port").toString());
			String queue=(String) MqPropertiesUtils.pro.get("store_queue");
			String exchange=(String) MqPropertiesUtils.pro.get("store_exchange");
			String key=(String) MqPropertiesUtils.pro.get("store_key");
			//JmsConsumer jmsConsumer=new JmsConsumer("18.234.205.204", "coupon", "Ppp12345", 5672,"online_store_queue","scrapy","store");
			JmsConsumer jmsConsumer=new JmsConsumer(borkUrl, userName, password, port,queue,exchange,key);
			jmsConsumer.start();
			
			//定义消费者
	        DefaultConsumer consumer = new DefaultConsumer(jmsConsumer.getChannel()) {
	            @Override
	            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
	            	executor.execute(new Thread(new Runnable() {
				  
				 @Override 
				 public void run() {
					 String msg=null;
					try {
						msg = new String(body, "utf-8");
						TMessage message=new TMessage();
						message.setMessageBody(msg);
						messageDataService.insertStoreMessages(message);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		              
				 }}));
	               
	            }
	        };
	        //监听队列
	        jmsConsumer.getChannel().basicConsume(jmsConsumer.getQueue(),true,consumer);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}
	
}
