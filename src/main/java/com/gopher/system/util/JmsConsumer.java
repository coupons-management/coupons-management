//package com.gopher.system.util;
//
//import java.io.IOException;
//
//import com.rabbitmq.client.AMQP;
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//import com.rabbitmq.client.DefaultConsumer;
//import com.rabbitmq.client.Envelope;
//import com.rabbitmq.client.QueueingConsumer;
//
//public class JmsConsumer {
//	private ConnectionFactory factory;
//	private String borkUrl;
//	private String userName;
//	private String password;
//	private int port;
//	private String queue;
//	private String key;
//	private String exchangeName;
//	private Connection connection;
//	private Channel channel;
//
//	public JmsConsumer(String borkUrl, String userName, String password, int port,String queue,String exchangeName,String key) {
//		super();
//		this.borkUrl = borkUrl;
//		this.userName = userName;
//		this.password = password;
//		this.port = port;
//		this.queue = queue;
//		this.exchangeName = exchangeName;
//		this.key = key;
//
//	}
//
//	public JmsConsumer() {
//
//	}
//
//	public String getExchangeName() {
//		return exchangeName;
//	}
//
//	public void setExchangeName(String exchangeName) {
//		this.exchangeName = exchangeName;
//	}
//
//	public Connection getConnection() {
//		return connection;
//	}
//
//	public void setConnection(Connection connection) {
//		this.connection = connection;
//	}
//
//	public Channel getChannel() {
//		return channel;
//	}
//
//	public void setChannel(Channel channel) {
//		this.channel = channel;
//	}
//
//	public int getPort() {
//		return port;
//	}
//
//	public void setPort(int port) {
//		this.port = port;
//	}
//
//	public ConnectionFactory getFactory() {
//		return factory;
//	}
//
//	public void setFactory(ConnectionFactory factory) {
//		this.factory = factory;
//	}
//
//	public String getBorkUrl() {
//		return borkUrl;
//	}
//
//	public void setBorkUrl(String borkUrl) {
//		this.borkUrl = borkUrl;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getQueue() {
//		return queue;
//	}
//
//	public void setQueue(String queue) {
//		this.queue = queue;
//	}
//
//
//
//	public String getKey() {
//		return key;
//	}
//
//	public void setKey(String key) {
//		this.key = key;
//	}
//
//	public void start() throws Exception {
//		//定义一个连接工厂
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        //设置服务器地址
//        connectionFactory.setHost(this.getBorkUrl());
//        //AMQP 15672
//        connectionFactory.setPort(this.getPort());
//        //设置用户名
//        connectionFactory.setUsername(this.getUserName());
//        //设置密码
//        connectionFactory.setPassword(this.getPassword());
//      //获取连接
//         connection =connectionFactory.newConnection();
//       //从连接中获取通道
//	     channel = connection.createChannel();
//         channel.queueDeclare(queue,false,false,false,null);
//         // 绑定队列到交换机
//         channel.queueBind(queue, this.getExchangeName(), this.getKey());
//         //channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "delete");
//        // channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "insert");
//
//         // 同一时刻服务器只会发一条消息给消费者
//         channel.basicQos(1);
//
//         // 定义队列的消费者
//         QueueingConsumer consumer = new QueueingConsumer(channel);
//         // 监听队列，手动返回完成
//         channel.basicConsume(queue, false, consumer);
//	}
//
//	public static void main(String[] args) {
//		//JmsConsumer jmsConsumer=new JmsConsumer();
//		JmsConsumer jmsConsumer=new JmsConsumer("18.234.205.204", "coupon", "Ppp12345", 5672,"online_store_queue","scrapy","store");
//		try {
//			jmsConsumer.start();
//
//			//定义消费者
//	        DefaultConsumer consumer = new DefaultConsumer(jmsConsumer.getChannel()) {
//	            @Override
//	            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//	                String msg = new String(body, "utf-8");
//	                System.out.println("recv msg:" + msg);
//	            }
//	        };
//
//	        //监听队列
//	        jmsConsumer.getChannel().basicConsume(jmsConsumer.getQueue(),true,consumer);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//
//	}
//
//}
