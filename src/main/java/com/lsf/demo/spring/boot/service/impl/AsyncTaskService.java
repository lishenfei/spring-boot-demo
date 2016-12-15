package com.lsf.demo.spring.boot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * Created by lishenfei on 2016-12-12.
 */
@Service
@Slf4j
public class AsyncTaskService {

    @Async // 声明为异步执行
    public void executeAsyncTask1(Integer i) {
        log.info("执行异步任务1：{}", i);
    }

    @Async // 声明为异步执行
    public void executeAsyncTask2(Integer i) {
        log.info("执行异步任务2：{}", i);
    }

}
