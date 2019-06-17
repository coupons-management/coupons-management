//package com.gopher.system.listener;
//
//import com.gopher.system.model.entity.CpScrapy;
//import com.gopher.system.model.entity.TMessage;
//import com.gopher.system.service.MessageDataService;
//import com.gopher.system.util.DataCacheUtils;
//import com.gopher.system.util.JmsConsumer;
//import com.gopher.system.util.MqPropertiesUtils;
//import com.gopher.system.util.SpringContextUtil;
//import com.rabbitmq.client.*;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.List;
//import java.util.concurrent.LinkedBlockingDeque;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeoutException;
//import java.util.concurrent.locks.LockSupport;
//
///**
// * Application Lifecycle Listener implementation class MessageListener
// *
// */
//@WebListener
//public class MessageListener2 implements ServletContextListener {
//	private Log logger=LogFactory.getLog(MessageListener2.class);
//	ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(5));
//
//	/**
//     * Default constructor.
//     */
//    public MessageListener2() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
//     */
//    public void contextDestroyed(ServletContextEvent sce)  {
//         // TODO Auto-generated method stub
//    }
//
//	/**
//     * @see ServletContextListener#contextInitialized(ServletContextEvent)
//     */
//    public void contextInitialized(ServletContextEvent sce)  {
//     	this.synCategory();
//        this.synStore();
//        this.synCoupon();
//        this.synSpiderStatus();
//        this.initScrapy();
//
//    }
//
//
//    /**
//     * 联接MQ，接收商家类型消息
//     */
//    public  void synCategory() {
//    	MessageDataService messageDataService=(MessageDataService) SpringContextUtil.getBean("messageDataService");
//		try {
//
//			//JmsConsumer jmsConsumer=new JmsConsumer("18.234.205.204", "coupon", "Ppp12345", 5672,"online_category_queue","scrapy","category");
//			String borkUrl=(String) MqPropertiesUtils.pro.get("category_borkUrl");
//			String userName=(String) MqPropertiesUtils.pro.get("category_userName");
//			String password=(String) MqPropertiesUtils.pro.get("category_password");
//			int port=Integer.parseInt( MqPropertiesUtils.pro.get("category_port").toString());
//			String queue=(String) MqPropertiesUtils.pro.get("category_queue");
//			String exchange=(String) MqPropertiesUtils.pro.get("category_exchange");
//			String key=(String) MqPropertiesUtils.pro.get("category_key");
//			JmsConsumer jmsConsumer=new JmsConsumer(borkUrl, userName, password, port,queue,exchange,key);
//			jmsConsumer.start();
//
//			//定义消费者
//	        DefaultConsumer consumer = new DefaultConsumer(jmsConsumer.getChannel()) {
//	            @Override
//	            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//	            	executor.execute(new Thread(new Runnable() {
//
//				 @Override
//				 public void run() {
//					 String msg=null;
//					try {
//						msg = new String(body, "utf-8");
//						TMessage message=new TMessage();
//						message.setMessageBody(msg);
//						messageDataService.insertCategoryMessages(message);
//					} catch (UnsupportedEncodingException e) {
//						logger.debug(e);
//					}
//
//				 }}));
//
//	            }
//	        };
//	        //监听队列
//	        jmsConsumer.getChannel().basicConsume(jmsConsumer.getQueue(),true,consumer);
//		} catch (Exception e) {
//			logger.debug(e);
//		}
//
//
//	}
//
//
//    public  void synCoupon() {
//    	MessageDataService messageDataService=(MessageDataService) SpringContextUtil.getBean("messageDataService");
//		try {
//			String borkUrl=(String) MqPropertiesUtils.pro.get("coupon_borkUrl");
//			String userName=(String) MqPropertiesUtils.pro.get("coupon_userName");
//			String password=(String) MqPropertiesUtils.pro.get("coupon_password");
//			int port=Integer.parseInt( MqPropertiesUtils.pro.get("coupon_port").toString());
//			String queue=(String) MqPropertiesUtils.pro.get("coupon_queue");
//			String exchange=(String) MqPropertiesUtils.pro.get("coupon_exchange");
//			String key=(String) MqPropertiesUtils.pro.get("coupon_key");
//
//			JmsConsumer jmsConsumer=new JmsConsumer(borkUrl, userName, password, port,queue,exchange,key);
//			jmsConsumer.start();
//
//			//定义消费者
//	        DefaultConsumer consumer = new DefaultConsumer(jmsConsumer.getChannel()) {
//	            @Override
//	            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//	            	executor.execute(new Thread(new Runnable() {
//
//				 @Override
//				 public void run() {
//					 String msg=null;
//					try {
//						msg = new String(body, "utf-8");
//						TMessage message=new TMessage();
//						message.setMessageBody(msg);
//						messageDataService.insertCouponMessages(message);
//					} catch (UnsupportedEncodingException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				 }}));
//
//	            }
//	        };
//	        //监听队列
//	        jmsConsumer.getChannel().basicConsume(jmsConsumer.getQueue(),true,consumer);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//
//	}
//    public  void synStore() {
//    	MessageDataService messageDataService=(MessageDataService) SpringContextUtil.getBean("messageDataService");
//		try {
//			String borkUrl=(String) MqPropertiesUtils.pro.get("store_borkUrl");
//			String userName=(String) MqPropertiesUtils.pro.get("store_userName");
//			String password=(String) MqPropertiesUtils.pro.get("store_password");
//			int port=Integer.parseInt( MqPropertiesUtils.pro.get("store_port").toString());
//			String queue=(String) MqPropertiesUtils.pro.get("store_queue");
//			String exchange=(String) MqPropertiesUtils.pro.get("store_exchange");
//			String key=(String) MqPropertiesUtils.pro.get("store_key");
//			//JmsConsumer jmsConsumer=new JmsConsumer("18.234.205.204", "coupon", "Ppp12345", 5672,"online_store_queue","scrapy","store");
//			JmsConsumer jmsConsumer=new JmsConsumer(borkUrl, userName, password, port,queue,exchange,key);
//			jmsConsumer.start();
//
//			//定义消费者
//	        DefaultConsumer consumer = new DefaultConsumer(jmsConsumer.getChannel()) {
//	            @Override
//	            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//	            	executor.execute(new Thread(new Runnable() {
//
//				 @Override
//				 public void run() {
//					 String msg=null;
//					try {
//						msg = new String(body, "utf-8");
//						TMessage message=new TMessage();
//						message.setMessageBody(msg);
//						messageDataService.insertStoreMessages(message);
//					} catch (UnsupportedEncodingException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				 }}));
//
//	            }
//	        };
//	        //监听队列
//	        jmsConsumer.getChannel().basicConsume(jmsConsumer.getQueue(),true,consumer);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//
//	}
//
//
//    public  void synSpiderStatus() {
//    	MessageDataService messageDataService=(MessageDataService) SpringContextUtil.getBean("messageDataService");
//		try {
//			String borkUrl=(String) MqPropertiesUtils.pro.get("spider_status_borkUrl");
//			String userName=(String) MqPropertiesUtils.pro.get("spider_status_userName");
//			String password=(String) MqPropertiesUtils.pro.get("spider_status_password");
//			int port=Integer.parseInt( MqPropertiesUtils.pro.get("spider_status_port").toString());
//			String queue=(String) MqPropertiesUtils.pro.get("spider_status");
//			String exchange=(String) MqPropertiesUtils.pro.get("spider_status_exchange");
//			String key=(String) MqPropertiesUtils.pro.get("spider_status_key");
//			//JmsConsumer jmsConsumer=new JmsConsumer("18.234.205.204", "coupon", "Ppp12345", 5672,"online_store_queue","scrapy","store");
//			JmsConsumer jmsConsumer=new JmsConsumer(borkUrl, userName, password, port,queue,exchange,key);
//			jmsConsumer.start();
//
//			//定义消费者
//	        DefaultConsumer consumer = new DefaultConsumer(jmsConsumer.getChannel()) {
//	            @Override
//	            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//	            	executor.execute(new Thread(new Runnable() {
//
//				 @Override
//				 public void run() {
//					 String msg=null;
//					try {
//						msg = new String(body, "utf-8");
//						messageDataService.updateCouponIndex(msg);
//					} catch (UnsupportedEncodingException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				 }}));
//
//	            }
//	        };
//	        //监听队列
//	        jmsConsumer.getChannel().basicConsume(jmsConsumer.getQueue(),true,consumer);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//
//
//    /**
//     * 初始化爬虫数据
//     */
//    public  void initScrapy() {
//    	MessageDataService messageDataService=(MessageDataService) SpringContextUtil.getBean("messageDataService");
//		try {
//			List<CpScrapy> list=messageDataService.getScrapyList();
//			for(CpScrapy cp:list)
//			{
//				DataCacheUtils.scrapyMap.put(cp.getName(), cp.getWeight());
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//
//
//	public void testBasicGet() {
//		String userName = "jannal";
//		String password = "jannal";
//		String virtualHost = "scrapy";
//		String hostName = "IP地址";
//		String queueName = "队列名称";
//		int portNumber = 5672;
//		ConnectionFactory factory = new ConnectionFactory();
//		factory.setUsername(userName);
//		factory.setPassword(password);
//		factory.setVirtualHost(virtualHost);
//		factory.setHost(hostName);
//		factory.setPort(portNumber);
//		factory.setAutomaticRecoveryEnabled(false);
//
//		Connection conn = null;
//		try {
//			conn = factory.newConnection();
//			final Channel channel = conn.createChannel();
//			// 拉模式设置无效                channel.basicQos(1);
//			//不自动确认
//			boolean autoAck = false;
//			//true表示不能将一个Connection中生产者发送的消息传送给这个Connection中的消费者
//			boolean noLocal = false;
//			//是否独占
//			boolean exclusive = false;
//
//			GetResponse getResponse = channel.basicGet(queueName, autoAck);
//			if (getResponse != null) {
//				System.out.println("Consumer2:" + new String(getResponse.getBody(), "utf-8"));
//				long deliveryTag = getResponse.getEnvelope().getDeliveryTag();
//				channel.basicAck(deliveryTag, false);
//			}
//
//			LockSupport.park();
//		} catch (IOException e) {
//			logger.error(e.getMessage(), e);
//		} catch (TimeoutException e) {
//			logger.error(e.getMessage(), e);
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//
//}
