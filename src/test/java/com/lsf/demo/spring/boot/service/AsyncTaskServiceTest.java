package com.lsf.demo.spring.boot.service;

import com.lsf.demo.spring.boot.service.impl.AsyncTaskService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * AsyncTaskService Tester.
 *
 * @author lishenfei
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AsyncTaskServiceTest {

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testExecuteAsyncTask() throws Exception {

        for (int i = 0; i < 3; i++) {
            asyncTaskService.executeAsyncTask1(i);
            asyncTaskService.executeAsyncTask2(i);
        }

    }


}
