package com.pqb.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mqMessageController")
public class ProducerDemo {

    @Resource
    RocketMQTemplate rocketMQTemplate;
    @PostMapping("/mqSend")
    public void test() {
        // 往powernode的主题里面发送一个简单的字符串消息
        SendResult sendResult = rocketMQTemplate.syncSend("my-topic", "我是一个简单的消息");
        // 拿到消息的发送状态
        System.out.println("拿到消息的发送状态"+sendResult.getSendStatus());
        // 拿到消息的id
        System.out.println("拿到消息的id"+sendResult.getMsgId());
    }
}
