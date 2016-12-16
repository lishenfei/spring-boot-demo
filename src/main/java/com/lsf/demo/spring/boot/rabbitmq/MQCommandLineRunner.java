package com.lsf.demo.spring.boot.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by lishenfei on 2016-12-16.
 */
@Component
public class MQCommandLineRunner implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... strings) throws Exception {
        for (String msg : strings) {
            rabbitTemplate.convertAndSend("my-queue", msg);
        }
    }
}
