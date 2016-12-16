package com.lsf.demo.spring.boot.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lishenfei on 2016-12-16.
 */
@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue.name}")
    private String queueName;

    @Bean
    public Queue commonQueue() {
        return new Queue(queueName);
    }

}
