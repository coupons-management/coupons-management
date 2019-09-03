package com.gopher.system.listener;

import com.gopher.system.model.entity.TMessage;
import com.gopher.system.service.MessageDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

public class SpiderMessageListener implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(SpiderMessageListener.class);
    @Autowired
    private MessageDataService messageDataService;

    private final String online_coupon_queue = "online_coupon_queue";
    private final String online_category_queue = "online_category_queue";
    private final String online_store_queue = "online_store_queue";
    private final String spider_status = "spider_status";
    @Override
    public void onMessage(Message message) {
        try {
            final String queue = message.getMessageProperties().getConsumerQueue();
            final String message_content = new String(message.getBody(), "UTF-8");
            logger.info("queue name:{}", queue);
//            logger.info("message:{}", message_content);
            TMessage tmessage = new TMessage();
            tmessage.setMessageBody(message_content);
            switch (queue) {
                case online_coupon_queue:
                    messageDataService.insertCouponMessages(tmessage);
                    break;
                case online_category_queue:
                    messageDataService.insertCategoryMessages(tmessage);
                    break;
                case online_store_queue:
                    messageDataService.insertStoreMessages(tmessage);
                    break;
                case spider_status:
                    //messageDataService.updateCouponIndex(message_content);
                    //messageDataService.updateScrapyRunState(message_content);
                    break;
                default:
                    logger.info("未能识别的消息 queueName:{} content:{}", queue, message_content);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}

