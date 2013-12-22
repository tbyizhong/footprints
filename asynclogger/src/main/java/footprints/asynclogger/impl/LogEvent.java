package footprints.asynclogger.impl;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-22
 * Time: 下午7:41
 */
public class LogEvent {
    private String msg;
    private Throwable tx;
    private Date logTime;

    public LogEvent() {
        logTime = new Date();
    }

    public LogEvent(String msg, Throwable tx) {
        super();
        this.msg = msg;
        this.tx = tx;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Throwable getTx() {
        return tx;
    }

    public void setTx(Throwable tx) {
        this.tx = tx;
    }

    public Date getLogTime() {
        return logTime;
    }

//    public String getThrowableStackTrace() {
//        if (tx == null) {
//            return null;
//        }
//
//
//    }
}
