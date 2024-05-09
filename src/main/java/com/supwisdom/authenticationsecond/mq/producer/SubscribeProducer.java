package com.supwisdom.authenticationsecond.mq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.supwisdom.authenticationsecond.conf.RabbitConfig.WORK_MODEL;

/**
 * @description:
 * @author: wxy
 * @create: 2024-05-09 18:21
 */


@Component
public class SubscribeProducer {


    @Autowired
    AmqpTemplate amqpTemplate;


    public String send(String message) {
        amqpTemplate.convertAndSend("stu_fanoutExchange", "", message);
        return "succ";
    }


}
