package footprints.asynclogger;

import footprints.asynclogger.impl.LogEvent;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-22
 * Time: 下午7:53
 */
public interface LogConsumer {
    void consume(LogEvent logEvent);
}
