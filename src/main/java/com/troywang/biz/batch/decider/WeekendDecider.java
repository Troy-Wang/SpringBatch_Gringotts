package com.troywang.biz.batch.decider;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.stereotype.Component;

import com.troywang.base.util.DateUtil;
import com.troywang.biz.constants.DeciderConstants;

/**
 * Created by troywang on 2018/5/16.
 */
@Component
public class WeekendDecider implements JobExecutionDecider {

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        return DateUtil.isWeekend(new Date()) ? (new FlowExecutionStatus(DeciderConstants.IS_WEEKEND))
                : (new FlowExecutionStatus(DeciderConstants.NOT_WEEKEND));
    }
}
