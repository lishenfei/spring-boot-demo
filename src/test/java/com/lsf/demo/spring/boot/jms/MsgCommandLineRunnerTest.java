package com.lsf.demo.spring.boot.jms;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * MsgCommandLineRunner Tester.
 *
 * @author lishenfei
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MsgCommandLineRunnerTest {

    @Autowired
    private MsgCommandLineRunner runner;

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
        runner.run("JMS第一条消息", "JMS第二条消息", "JMS第三条消息");
    }


} 
