package footprints.lock;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-24
 * Time: 下午4:27
 */
public abstract class AbstractLock implements Lock {
    protected Thread threadHoldingLock;

    public Thread getThreadHoldingLock() {
        return threadHoldingLock;
    }

    public void setThreadHoldingLock(Thread threadHoldingLock) {
        this.threadHoldingLock = threadHoldingLock;
    }
}
