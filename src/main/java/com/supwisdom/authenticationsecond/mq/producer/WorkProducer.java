package com.supwisdom.authenticationsecond.mq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.supwisdom.authenticationsecond.conf.RabbitConfig.WORK_MODEL;

/**
 * @description:
 * @author: wxy
 * @create: 2024-05-09 11:53
 */


@Component
public class WorkProducer {

    @Autowired
    AmqpTemplate amqpTemplate;

    public String sendWithReceive(String message) {
        String result = (String) amqpTemplate.convertSendAndReceive(WORK_MODEL, message);
        return result;
    }

    public String send(String message) {
        amqpTemplate.convertAndSend(WORK_MODEL, message);
        return "succ";
    }

}