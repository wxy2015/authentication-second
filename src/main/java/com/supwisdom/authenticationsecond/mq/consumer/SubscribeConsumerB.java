package com.supwisdom.authenticationsecond.mq.consumer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: wxy
 * @create: 2024-05-09 18:32
 */

@Component
@RabbitListener(queues = "queueB")
public class SubscribeConsumerB {

    @RabbitHandler
    public void receiverMessage(String message) throws Exception {
        System.out.println("消费者B：" + message);
    }
}
