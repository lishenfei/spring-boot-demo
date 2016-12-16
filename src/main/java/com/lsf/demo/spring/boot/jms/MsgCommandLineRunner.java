package com.lsf.demo.spring.boot.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by lishenfei on 2016-12-16.
 */
@Component
public class MsgCommandLineRunner implements CommandLineRunner {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${spring.activemq.queue.name}")
    private String destination;

    @Override
    public void run(String... strings) throws Exception {
        for (String msg : strings) {
            jmsTemplate.send(destination, session -> session.createTextMessage(msg));
        }
    }
}
