package footprints.lock;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-24
 * Time: 下午2:28
 */
public class FairLock extends RemeberThreadNameLock {

    private boolean locked = false;
    private LinkedList<Monitor> monitorList = new LinkedList<Monitor>();
    private Thread next;

    @Override
    public void lock() {
        boolean nameRemembered = false;
        try {
            while (true) {
                Monitor monitor = new Monitor(Thread.currentThread());
                synchronized (this) {
                    if (!nameRemembered){
                        remeberThreadName();
                    }
                    nameRemembered = true;
                    if (!locked && ((next==null)||(next != null && next == Thread.currentThread()))) {
                        locked = true;
                        threadHoldingLock = Thread.currentThread();
                        break;
                    } else {
                        monitorList.addLast(monitor);
                    }
                }
                synchronized (monitor) {
                    monitor.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void unlock() {
        if (threadHoldingLock != Thread.currentThread()) {
            return;
        }
        if (monitorList.size() > 0) {
            Monitor monitor = monitorList.removeFirst();
            next = monitor.getThreadWaitingOnThis();
            synchronized (monitor) {
                monitor.notify();
            }
        }
        locked = false;
    }
}

class Monitor {
    private Thread threadWaitingOnThis;

    public Monitor(Thread threadWaitingOnThis) {
        this.threadWaitingOnThis = threadWaitingOnThis;
    }

    Thread getThreadWaitingOnThis() {
        return threadWaitingOnThis;
    }

    void setThreadWaitingOnThis(Thread threadWaitingOnThis) {
        this.threadWaitingOnThis = threadWaitingOnThis;
    }
}