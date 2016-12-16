package com.lsf.demo.spring.boot.rabbitmq;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * MQCommandLineRunner Tester.
 *
 * @author lishenfei
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MQCommandLineRunnerTest {

    @Autowired
    private MQCommandLineRunner runner;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: run(String... strings)
     */
    @Test
    public void testRun() throws Exception {
        runner.run("Rabbit第一条消息", "Rabbit第二条消息", "Rabbit第三条消息");
    }


} 
