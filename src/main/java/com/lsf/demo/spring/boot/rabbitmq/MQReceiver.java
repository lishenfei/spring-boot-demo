package com.lsf.demo.spring.boot.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听
 * Created by lishenfei on 2016-12-16.
 */
@Component
@Slf4j
public class MQReceiver {

    @RabbitListener(queues = "${spring.rabbitmq.queue.name}")
    public void receiveMessage(String message) {
        log.info("接收到消息：" + message);
    }

}
