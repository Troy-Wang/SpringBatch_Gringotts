package com.troywang.biz.job;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import com.troywang.base.exception.GringottsRetryableException;
import com.troywang.base.exception.GringottsSkippableException;
import com.troywang.biz.batch.listener.ExportStepExecutionListener;
import com.troywang.biz.batch.partitioner.FileProcessPartitioner;
import com.troywang.biz.batch.processor.BatchDetailExportProcessor;
import com.troywang.biz.batch.processor.CreateScheduleProcessor;
import com.troywang.biz.batch.tasklet.CtxInitTasklet;
import com.troywang.biz.batch.validator.JobParamValidator;
import com.troywang.biz.batch.writer.ScheduleCreateWriter;
import com.troywang.biz.model.BatchDetailExportModel;
import com.troywang.dal.entity.BatchDetailDo;
import com.troywang.dal.entity.BatchFileConfigDo;
import com.troywang.dal.entity.BatchScheduleDo;

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
    private CreateScheduleProcessor createScheduleProcessor;

    @Autowired
    private ScheduleCreateWriter scheduleCreateWriter;

    @Autowired
    private BatchDetailExportProcessor batchDetailExportProcessor;

    @Autowired
    private JobParamValidator jobParamValidator;

    /**
     * step级别的bean都在本configuration文件中
     */
    @Bean
    public Job fileProcessJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, Step
            createScheduleStep, Step fileExportPartitionStep) {
        // Step1. 初始化上下文
        Step fileProcessCtxInitStep = stepBuilderFactory.get("fileProcessCtxInitStep").tasklet(ctxInitTasklet).build();

        return jobBuilderFactory.get("fileProcessJob").validator(jobParamValidator).start(fileProcessCtxInitStep).next
                (createScheduleStep).next(fileExportPartitionStep).build();
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
        return stepBuilderFactory.get("createScheduleStep").<BatchFileConfigDo, BatchScheduleDo>chunk(2).faultTolerant()
                .retry(GringottsRetryableException.class).retryLimit(3).reader(fileConfigReader)
                .processor(createScheduleProcessor).writer(scheduleCreateWriter).build();
    }

    /**
     * Step3. 使用partition的方式处理每个文件导出
     *
     * @param stepBuilderFactory
     * @param detailExportStep
     *
     * @return
     */
    @Bean
    public Step fileExportPartitionStep(StepBuilderFactory stepBuilderFactory, Step detailExportStep) {
        return stepBuilderFactory.get("fileExportPartitionStep")
                .partitioner("detailExportStep", fileRecordValidatePartitioner()).step(detailExportStep)
                .taskExecutor(new SimpleAsyncTaskExecutor()).build();
    }

    @Bean
    @Scope(value = "step", proxyMode = ScopedProxyMode.INTERFACES)
    public Partitioner fileRecordValidatePartitioner() {
        return new FileProcessPartitioner();
    }

    @Bean
    public Step detailExportStep(StepBuilderFactory stepBuilderFactory, ItemReader<BatchDetailDo> batchDetailReader,
                                 ItemWriter<BatchDetailExportModel> batchDetailExportWriter,
                                 ExportStepExecutionListener exportStepExecutionListener) {
        return stepBuilderFactory.get("detailExportStep").<BatchDetailDo, BatchDetailExportModel>chunk(1)
                .faultTolerant().skip(GringottsSkippableException.class).skipLimit(3)
                .retry(GringottsRetryableException.class).retryLimit(3).reader(batchDetailReader)
                .processor(batchDetailExportProcessor).writer(batchDetailExportWriter)
                .listener(exportStepExecutionListener).build();
    }

    @Bean
    public ExportStepExecutionListener exportStepExecutionListener() {
        return new ExportStepExecutionListener();
    }

}
