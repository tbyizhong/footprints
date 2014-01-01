package footprints.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * Not Finished
 * <p/>
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-25
 * Time: 下午10:28
 */
public class RWLock extends RemeberThreadNameLock {
    private Thread writingThread;
    private List<Thread> readingThreads = new ArrayList<Thread>();
    private List<Monitor> monitors = new ArrayList<Monitor>();

    private synchronized boolean isReading() {
        return !readingThreads.isEmpty();
    }

    private synchronized boolean isWriting() {
        return writingThread != null;
    }

    private synchronized boolean writeShouldWait() {
        return writingThread != null || !readingThreads.isEmpty();
    }

    private synchronized boolean readShouldWait() {
        return writingThread != null;
    }

    public void readLock() {
        while (true) {
            Monitor monitor = new Monitor(Thread.currentThread());
            synchronized (this) {
                if (readShouldWait()) {
                    monitors.add(monitor);
                } else {
                    readingThreads.add(Thread.currentThread());
                    return;
                }
            }
            try {
                monitor.doWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void lock() {
        writeLock();
    }

    public void writeLock() {
        System.out.println(Thread.currentThread().getName() + " is --locking...");
        while (true) {
            Monitor monitor = new Monitor(Thread.currentThread());
            synchronized (this) {
                if (writeShouldWait()) {
                    monitors.add(monitor);
                } else {
                    writingThread = Thread.currentThread();
                    return;
                }
            }
            try {
                monitor.doWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void unlock() {
        System.out.println(Thread.currentThread().getName() + " is unlocking...");
        if (monitors.size() > 0) {
            Monitor first = monitors.remove(0);
            first.doNotify();
            if (first.getThreadWaitingOnThis() == writingThread) {
                writingThread = null;
            } else {
                readingThreads.remove(first.getThreadWaitingOnThis());
            }
        } else {
            writingThread = null;
            readingThreads.clear();
        }
    }

}
