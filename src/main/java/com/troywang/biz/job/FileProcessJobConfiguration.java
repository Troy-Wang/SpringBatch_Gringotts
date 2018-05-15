package com.troywang.biz.job;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.troywang.biz.batch.tasklet.CtxInitTasklet;

/**
 * Created by troywang on 2018/5/15.
 */
//@Configuration
//@EnableBatchProcessing
public class FileProcessJobConfiguration {

    //    @Autowired
    //    private DataSource dataSource;
    //
    //    @Autowired
    //    private CtxInitTasklet ctxInitTasklet;
    //
    //    /**
    //     * step级别的bean都在本configuration文件中
    //     *
    //     * @param createScheduleStep
    //     * @param fileDownloadStep
    //     * @param filePreCheckStep
    //     * @param fileRecordValidatePartitionStep
    //     *
    //     * @return
    //     */
    //    @Bean
    //    public Job fileProcessJob(StepBuilderFactory stepBuilderFactory, Step createScheduleStep, Step
    // fileDownloadStep,
    //                              Step filePreCheckStep,
    //                              Step fileRecordValidatePartitionStep) {
    //        // Step1. 初始化上下文
    //        Step fileProcessCtxInitStep = stepBuilderFactory.get("fileProcessCtxInitStep").tasklet(ctxInitTasklet)
    // .build();
    //        Step confirmJobTriggerStep =
    //                stepBuilderFactory.get("confirmJobTriggerStep").tasklet(confirmJobTriggerTasklet).build();
    //        return jobBuilderFactory.get("fileProcessJob").start(fileProcessCtxInitStep).next(createScheduleStep)
    //                .next(filePreCheckStep).next(fileRecordValidatePartitionStep)
    //                .next(confirmJobTriggerStep).build();
    //    }
    //
    //    /**
    //     * Step2. 针对符合条件的batch_file_config创建对应的batch_schedule
    //     *
    //     * @param fileConfigReader
    //     *
    //     * @return
    //     *
    //     * @see com.baidu.insurbatch.biz.batch.reader.FileConfigReaders
    //     * @see BatchScheduleCreateProcessor
    //     * @see BatchScheduleWriter
    //     */
    //    @Bean
    //    public Step createScheduleStep(StepBuilderFactory stepBuilderFactory, ItemReader<BatchFileConfigDo>
    //            fileConfigReader) {
    //        return stepBuilderFactory.get("createScheduleStep").<BatchFileConfigDo, ScheduleCreateRequest>chunk(2)
    //                .faultTolerant().skip(IBException.class).skipLimit(1000).reader(fileConfigReader)
    //                .processor(batchScheduleCreateProcessor).writer(batchScheduleWriter).build();
    //    }

}
