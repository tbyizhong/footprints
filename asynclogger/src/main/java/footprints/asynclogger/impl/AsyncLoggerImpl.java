package footprints.asynclogger.impl;

import footprints.asynclogger.AsyncLogger;
import footprints.asynclogger.LogScheduler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-22
 * Time: 下午7:48
 */
@Service
public class AsyncLoggerImpl implements AsyncLogger {
    @Resource
    private LogScheduler logScheduler;

    public void log(String msg) {
        log(msg, null);
    }

    public void log(String msg, Throwable tx) {
        LogEvent logEvent = new LogEvent(msg, tx);
        logScheduler.recieve(logEvent);
    }
}


