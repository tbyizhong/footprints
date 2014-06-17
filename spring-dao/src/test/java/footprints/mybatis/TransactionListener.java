package footprints.mybatis;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;

/**
 * Created by luoquan on 14-5-29.
 */
public class TransactionListener extends TransactionSynchronizationAdapter {
    @Override
    public void beforeCommit(boolean readOnly) {
        System.out.println("before commit.....");
    }

    @Override
    public void beforeCompletion() {
        System.out.println("before complete.....");
    }
}
