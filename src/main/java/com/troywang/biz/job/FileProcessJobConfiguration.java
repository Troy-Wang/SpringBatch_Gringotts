package com.troywang.biz.job;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.troywang.biz.batch.processor.EmptyProcessor;
import com.troywang.biz.batch.tasklet.CtxInitTasklet;
import com.troywang.biz.batch.writer.EmptyWriter;
import com.troywang.dal.entity.BatchFileConfigDo;

/**
 * Created by troywang on 2018/5/15.
 */
@Configuration
@EnableBatchProcessing
public class FileProcessJobConfiguration {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CtxInitTasklet ctxInitTasklet;

    @Autowired
    private EmptyProcessor emptyProcessor;

    /**
     * step级别的bean都在本configuration文件中
     */
    @Bean
    public Job fileProcessJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, Step
            createScheduleStep) {
        // Step1. 初始化上下文
        Step fileProcessCtxInitStep = stepBuilderFactory.get("fileProcessCtxInitStep").tasklet(ctxInitTasklet)
                .build();
        return jobBuilderFactory.get("fileProcessJob").start(fileProcessCtxInitStep).next(createScheduleStep)
                .build();
    }

    /**
     * Step2. 针对符合条件的batch_file_config创建对应的batch_schedule
     *
     * @param fileConfigReader
     *
     * @return
     */
    @Bean
    public Step createScheduleStep(StepBuilderFactory stepBuilderFactory, ItemReader<BatchFileConfigDo>
            fileConfigReader) {
        return stepBuilderFactory.get("createScheduleStep").<BatchFileConfigDo, Object>chunk(2)
                .reader(fileConfigReader).processor(emptyProcessor).writer(new EmptyWriter()).build();
    }

}
