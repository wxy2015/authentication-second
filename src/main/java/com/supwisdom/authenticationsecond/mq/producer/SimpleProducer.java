package com.supwisdom.authenticationsecond.mq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

import static com.supwisdom.authenticationsecond.conf.RabbitConfig.SIMPLE_MODEL;

/**
 * @description:
 * @author: wxy
 * @create: 2024-05-09 11:53
 */


@Component
public class SimpleProducer {

    @Autowired
    AmqpTemplate amqpTemplate;

    public String send(String message) {
        String result = (String) amqpTemplate.convertSendAndReceive(SIMPLE_MODEL, message);
        return result;
    }

}