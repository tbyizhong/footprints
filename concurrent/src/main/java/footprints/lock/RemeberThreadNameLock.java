package footprints.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-24
 * Time: 下午3:42
 */
public abstract class RemeberThreadNameLock extends AbstractLock {
    protected List<String> threadNames = new ArrayList<String>();

    protected synchronized void remeberThreadName() {
        threadNames.add("lock_" + Thread.currentThread().getName());
    }

    public List<String> getThreadNames() {
        return threadNames;
    }

    public void setThreadNames(List<String> threadNames) {
        this.threadNames = threadNames;
    }
}
