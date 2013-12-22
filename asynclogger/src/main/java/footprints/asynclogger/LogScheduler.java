package footprints.asynclogger;

import footprints.asynclogger.impl.LogEvent;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-22
 * Time: 下午7:46
 */
@Service
public interface LogScheduler {
    public boolean recieve(LogEvent logEvent);
}
