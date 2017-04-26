package troywang.gringotts.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Created by wangzhijian02 on 2016/12/14.
 */
public class MessageJobListener implements JobExecutionListener {

    public void beforeJob(JobExecution jobExecution) {
        System.out.println("before job called....");
    }

    public void afterJob(JobExecution jobExecution) {
        System.out.println("after job called....");
        System.out.println(jobExecution.getEndTime().getTime() - jobExecution.getStartTime().getTime());
    }

}
