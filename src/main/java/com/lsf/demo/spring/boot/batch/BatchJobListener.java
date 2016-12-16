package com.lsf.demo.spring.boot.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * 自定义Job监听
 */
@Slf4j
public class BatchJobListener implements JobExecutionListener {

    private long startTime;
    private long endTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        log.info("批量任务开始执行，{}", jobExecution.toString());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        log.info("批量任务处理结束，耗时：{}ms，{}", (endTime - startTime), jobExecution.toString());
    }

}
