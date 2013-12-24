package footprints.lock;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-24
 * Time: 下午3:17
 */
public class UnFairLock extends RemeberThreadNameLock {
    private boolean locked = false;

    @Override
    public synchronized void lock() {
        try {
            remeberThreadName();
            while (locked) {
                wait();
            }
            locked = true;
            threadHoldingLock = Thread.currentThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void unlock() {
        if (threadHoldingLock == Thread.currentThread()) {
            locked = false;
            notify();
        }
    }
}
