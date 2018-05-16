package com.troywang.biz.batch.tasklet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import com.troywang.biz.constants.JobConstants;
import com.troywang.biz.model.JobContextModel;

/**
 * init job execution context
 * Created by troywang on 2018/5/15.
 */
@Component
public class CtxInitTasklet implements Tasklet {

    private static final Logger logger = LoggerFactory.getLogger(CtxInitTasklet.class);

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        logger.info("[ctx init tasklet] start initializing job context");
        JobContextModel ctxModel = new JobContextModel();
        ctxModel.setFoo("foo");
        chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext()
                .put(JobConstants.JOB_CONTEXT, ctxModel);
        logger.info("[ctx init tasklet] initialize job context={}", ctxModel);
        return RepeatStatus.FINISHED;
    }
}
