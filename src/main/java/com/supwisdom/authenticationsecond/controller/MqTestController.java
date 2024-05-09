package com.supwisdom.authenticationsecond.controller;

import com.alibaba.fastjson.JSONObject;
import com.supwisdom.authenticationsecond.model.IdentityType;
import com.supwisdom.authenticationsecond.mq.producer.SimpleProducer;
import com.supwisdom.authenticationsecond.mq.producer.SubscribeProducer;
import com.supwisdom.authenticationsecond.mq.producer.WorkProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 订阅
 * @author: wxy
 * @create: 2024-05-09 13:04
 */


@RestController
@RequestMapping("/testMq")
public class MqTestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SimpleProducer simpleProducer;
    @Autowired
    private WorkProducer workProducer;
    @Autowired
    private SubscribeProducer subscribeProducer;


    @GetMapping("/sendSimple")
    public String sendSimple(String message){
//        message = "{\"name\":\"BeJson\",\"url\":\"http://www.bejson.com\",\"page\":88,\"isNonProfit\":true,\"address\":{\"street\":\"科技园路.\",\"city\":\"江苏苏州\",\"country\":\"中国\"},\"links\":[{\"name\":\"Google\",\"url\":\"http://www.google.com\"},{\"name\":\"Baidu\",\"url\":\"http://www.baidu.com\"},{\"name\":\"SoSo\",\"url\":\"http://www.SoSo.com\"}]}";
        IdentityType identityType = new IdentityType();
        identityType.setCode("asdasda");
        identityType.setName("实打实的sad");
        identityType.setEnable(false);
        identityType.setSort(0L);

        simpleProducer.send(JSONObject.toJSONString(identityType));
        return "succ";
    }


    @GetMapping("/sendWork")
    public String sendWork(String message){
        for (int i = 0; i < 10; i++) {
            workProducer.send(message + " " + i);
        }
        return "succ";
    }

    @GetMapping("/sendSubscribe")
    public String sendSubscribe(String message){
        subscribeProducer.send(message);
        return "succ";
    }

}