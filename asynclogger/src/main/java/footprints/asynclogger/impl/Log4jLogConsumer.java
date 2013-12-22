package footprints.asynclogger.impl;

import footprints.asynclogger.LogConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-22
 * Time: 下午7:53
 */
@Service
public class Log4jLogConsumer implements LogConsumer {
    private static final Logger logger = LoggerFactory.getLogger(Log4jLogConsumer.class);

    @Override
    public void consume(LogEvent logEvent) {
        String msg = logEvent.getMsg();
        Throwable tx = logEvent.getTx();

        if (tx == null) {
            logger.warn(msg);
        } else {
            logger.error(msg, tx);
        }
    }
}
