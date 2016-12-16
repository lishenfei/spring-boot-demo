package com.lsf.demo.spring.boot.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听
 * Created by lishenfei on 2016-12-16.
 */
@Component
@Slf4j
public class MsgReceiver {

    @JmsListener(destination = "${spring.activemq.queue.name}")
    public void receiveMessage(String message) {
        log.info("接收到消息：" + message);
    }

}
