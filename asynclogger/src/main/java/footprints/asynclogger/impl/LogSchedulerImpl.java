package footprints.asynclogger.impl;

import footprints.asynclogger.LogConsumer;
import footprints.asynclogger.LogScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-22
 * Time: 下午7:51
 */
@Service
public class LogSchedulerImpl implements LogScheduler {
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5000);
    private ThreadPoolExecutor consumers = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, queue, new ThreadPoolExecutor.DiscardPolicy());
    @Autowired
    @Qualifier("fileLogConsumer")
    private LogConsumer fileLogConsumer;

    @Autowired
    @Qualifier("log4jLogConsumer")
    private LogConsumer log4jLogConsumer;

    @Override
    public boolean recieve(final LogEvent logEvent) {
        Future<?> result = consumers.submit(
                new Runnable() {
                    @Override
                    public void run() {
                        log4jLogConsumer.consume(logEvent);
                    }
                });


        return true;
    }
}
