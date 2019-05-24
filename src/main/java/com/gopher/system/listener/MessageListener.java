package com.gopher.system.listener;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.gopher.system.model.entity.TMessage;
import com.gopher.system.service.MessageDataService;
import com.gopher.system.util.JmsConsumer;
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
	ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
			new LinkedBlockingDeque<Runnable>(5));

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
     	this.synCategory();
        this.synStore();
        this.synCoupon();

    }
    
    
    
    public  void synCategory() {
    	MessageDataService messageDataService=(MessageDataService) SpringContextUtil.getBean("messageDataService");
		try {
			
			JmsConsumer jmsConsumer=new JmsConsumer("18.234.205.204", "coupon", "Ppp12345", 5672,"online_category_queue","scrapy","category");
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
    
    
    public  void synCoupon() {
    	MessageDataService messageDataService=(MessageDataService) SpringContextUtil.getBean("messageDataService");
		try {
			
			JmsConsumer jmsConsumer=new JmsConsumer("18.234.205.204", "coupon", "Ppp12345", 5672,"online_coupon_queue","scrapy","coupon");
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
			
			JmsConsumer jmsConsumer=new JmsConsumer("18.234.205.204", "coupon", "Ppp12345", 5672,"online_store_queue","scrapy","store");
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
