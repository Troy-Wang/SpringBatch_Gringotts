package troywang.gringotts.listener;

import org.springframework.batch.core.step.tasklet.SystemCommandException;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

/**
 * Created by wangzhijian02 on 2016/12/15.
 */
public class CommonRetryListener extends RetryListenerSupport {
    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback,
                                                 Throwable throwable) {
        System.out.println("JOB Retry automatically1");
        super.onError(context, callback, throwable);
        System.out.println("JOB Retry automatically2");
    }
}
