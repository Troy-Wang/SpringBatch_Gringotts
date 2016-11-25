import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class TestMain {

    public void runMessageJob() {
        ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext("message_job.xml");
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository((JobRepository) cpac.getBean("jobRepository"));
        launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        try {
            Map<String, JobParameter> param = new HashMap<String, JobParameter>();
            param.put("DAY_RUN", new JobParameter("2016-11-23"));
            JobExecution je = launcher.run((Job) cpac.getBean("messageJob"), new JobParameters(param));
            Thread.sleep(2000);
            System.out.println(je);
            System.out.println(je.getJobInstance());
            System.out.println(je.getStepExecutions());
            Thread.sleep(6000);
            launcher.run((Job) cpac.getBean("messageJob"), new JobParameters(param));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runBillingJob() {
        ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext("billing_job.xml");
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository((JobRepository) cpac.getBean("batchJobRepository"));
        launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        try {
            Map<String, JobParameter> param = new HashMap<String, JobParameter>();
            param.put("DAY_RUN", new JobParameter("1"));
            JobExecution je = launcher.run((Job) cpac.getBean("billingJob"), new JobParameters(param));
            Thread.sleep(10000);
            System.out.println(je);
            System.out.println(je.getJobInstance());
            System.out.println(je.getStepExecutions());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runTransConfirmJob() {
        ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext("gringotts_job_trans_confirm.xml");
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository((JobRepository) cpac.getBean("gringottsJobRepository"));
        launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        try {
            Map<String, JobParameter> param = new HashMap<String, JobParameter>();
            param.put("DAY_RUN", new JobParameter("2016-11-25"));
            JobExecution je = launcher.run((Job) cpac.getBean("gringottsJobTransConfirm"), new JobParameters(param));
            Thread.sleep(10000);
            System.out.println(je);
            System.out.println(je.getJobInstance());
            System.out.println(je.getStepExecutions());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestMain test = new TestMain();
        test.runTransConfirmJob();
    }

}
