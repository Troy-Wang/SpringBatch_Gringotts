package com.troywang.biz.job;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.troywang.biz.batch.processor.EmptyProcessor;
import com.troywang.biz.batch.reader.EmptyReader;
import com.troywang.biz.batch.writer.EmptyWriter;

/**
 * Created by troywang on 2018/5/14.
 */
@Configuration
@EnableBatchProcessing
public class DemoJobConfiguration {

    @Autowired
    private EmptyProcessor emptyProcessor;

    @Autowired
    private DataSource dataSource;

    @Bean
    public Job demoJob(JobBuilderFactory jobBuilderFactory) {
        return jobBuilderFactory.get("demoJob").start(demoStep(null)).build();
    }

    @Bean
    public Step demoStep(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("demoStep").chunk(1).reader(new EmptyReader()).processor(emptyProcessor)
                .writer(new EmptyWriter()).build();
    }
}
