package com.supwisdom.authenticationsecond.mq.consumer;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: wxy
 * @create: 2024-05-09 18:32
 */

@Component
@RabbitListener(queues = "queueA")
public class SubscribeConsumerA {

    @RabbitHandler
    public void receiverMessage(String message) throws Exception {
        System.out.println("消费者A：" + message);
    }
}
