package com.lsf.demo.spring.boot.web;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("batch")
@RestController
public class BatchJobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importJob;
    public JobParameters jobParameters;

    @RequestMapping("/read")
    public String imp(String fileName) throws Exception {

        String path = fileName + ".csv";
        jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .addString("input.file.name", path)
                .toJobParameters();
        jobLauncher.run(importJob, jobParameters);
        return "ok";
    }

}
