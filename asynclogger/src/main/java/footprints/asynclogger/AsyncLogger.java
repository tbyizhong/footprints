package footprints.asynclogger;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-22
 * Time: 下午7:49
 */
public interface AsyncLogger {
    public void log(String msg);
    public void log(String msg, Throwable tx);
}
