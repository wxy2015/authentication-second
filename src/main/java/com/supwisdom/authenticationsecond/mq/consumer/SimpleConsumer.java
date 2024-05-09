package com.supwisdom.authenticationsecond.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.supwisdom.authenticationsecond.conf.RabbitConfig.SIMPLE_MODEL;

/**
 * @description:
 * @author: wxy
 * @create: 2024-05-09 11:53
 */

@Component
@RabbitListener(queues = SIMPLE_MODEL)
public class SimpleConsumer {

    @RabbitHandler
    public String process(String message) {

        System.out.println("A:" + message);
        return "succ";
    }

}