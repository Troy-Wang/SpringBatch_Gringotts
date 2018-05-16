package com.troywang.biz.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.troywang.biz.enums.ScheduleStatusEnum;
import com.troywang.dal.dao.BatchScheduleDao;

/**
 * Created by troywang on 2018/5/16.
 */
public class ExportStepExecutionListener implements StepExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(ExportStepExecutionListener.class);

    @Autowired
    private BatchScheduleDao batchScheduleDao;

    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        logger.info("[step listener] after step execution, step={}", stepExecution.getStepName());
        String scheduleNo = stepExecution.getExecutionContext().getString("scheduleNo");
        if (stepExecution.getSkipCount() != 0) {
            logger.warn("[step listener] skip amount of step {} is not 0 but {}", stepExecution.getStepName(),
                    stepExecution.getSkipCount());
            String memo = String.format("文件内容有%d行错误", stepExecution.getSkipCount());
            batchScheduleDao.updateScheduleStatus(scheduleNo, ScheduleStatusEnum.ERROR.getStatus(), memo);
        } else {
            batchScheduleDao.updateScheduleStatus(scheduleNo, ScheduleStatusEnum.COMPLETE.getStatus(), "文件处理成功");
        }
        return ExitStatus.COMPLETED;
    }
}
