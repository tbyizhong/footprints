package footprints.lock;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-25
 * Time: 下午10:32
 */
public class Monitor {
    private Thread threadWaitingOnThis;
    private boolean notified;

    public Monitor(Thread threadWaitingOnThis) {
        this.threadWaitingOnThis = threadWaitingOnThis;
        this.notified = false;
    }

    public synchronized void doWait() throws InterruptedException {
        if (!notified) {
            wait();
            notified = false;
        }
    }

    public synchronized void doNotify() {
        notified = true;
        notify();
    }

    Thread getThreadWaitingOnThis() {
        return threadWaitingOnThis;
    }

    void setThreadWaitingOnThis(Thread threadWaitingOnThis) {
        this.threadWaitingOnThis = threadWaitingOnThis;
    }

    boolean isNotified() {
        return notified;
    }

    void setNotified(boolean notified) {
        this.notified = notified;
    }
}