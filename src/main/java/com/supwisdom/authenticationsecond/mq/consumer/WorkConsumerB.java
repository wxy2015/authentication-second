package com.supwisdom.authenticationsecond.mq.consumer;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.AMQP;
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
public class WorkConsumerB {

//    @RabbitHandler
//    public String process(String message) {
//        int millis = 3 * 1000;
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//        }
//        System.out.println("B:" + message);
//        return message + " sleep for " + millis + " ms";
//    }

    @RabbitHandler
    public void receiverMessage(String msg, Channel channel, Message message) throws Exception {
        System.out.println("消费者2 收到消息：" + msg);
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }


}