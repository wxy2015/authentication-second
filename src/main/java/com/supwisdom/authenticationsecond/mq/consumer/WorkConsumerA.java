package com.supwisdom.authenticationsecond.mq.consumer;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


import java.io.IOException;

import static com.supwisdom.authenticationsecond.conf.RabbitConfig.WORK_MODEL;

/**
 * @description:
 * @author: wxy
 * @create: 2024-05-09 11:53
 */

@Component
@RabbitListener(queues = WORK_MODEL)
public class WorkConsumerA {

//    @RabbitHandler
//    public String process(String message) {
//        int millis = 1 * 10;
//        try {
//            Thread.sleep(millis);
//        } catch (Exception e) {
//        }
//        System.out.println("A:" + message);
//        return message + " sleep for " + millis + " ms";
//    }

    @RabbitHandler
    public void receiverMessage(String msg, Channel channel, Message message) throws Exception {
        System.out.println("消费者1 收到消息：" + msg);
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

}