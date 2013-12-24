package footprints.lock;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-24
 * Time: 下午2:32
 */
public class LockTest {
    public static final int MAX_COUNT = 10000;
    public static final int THREAD_NUM = 100;

    @Test
    public void testUnFailLock() {
        testLock(new UnFairLock());
    }

    @Test
    public void testFailLock() {
        testLock(new FairLock());
    }

    public void testLock(Lock lock) {
        Producer p = new Producer(lock);
        List<Taker> takers = new ArrayList<Taker>();
        int threadNum = THREAD_NUM;
        for (int i = 0; i < threadNum; i++) {
            takers.add(new Taker("taker_" + (i + 1), p));
        }

        for (int i = 0; i < threadNum; i++) {
            takers.get(i).start();
        }


        try {
            for (int i = 0; i < threadNum; i++) {
                takers.get(i).join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int total = 0;
        for (int i = 0; i < threadNum; i++) {
            Taker taker = takers.get(i);
            List<Integer> taken = taker.getTaken();
            total += taken.size();
            System.out.println(taker.getName() + " total get:" + taken.size());
        }


        System.out.println("total:" + total);
        System.out.println("count now:" + p.now());

        //System.out.println(p.getThreadNames());
        writeFile("/tmp/producer", p.getThreadNames());
        if (lock instanceof RemeberThreadNameLock) {
            RemeberThreadNameLock rtnLock = (RemeberThreadNameLock) lock;
            //System.out.println(rtnLock.getThreadNames());
            writeFile("/tmp/lock", rtnLock.getThreadNames());
        }

    }

    private void writeFile(String path, List<String> list) {
        try {
            FileWriter fw = new FileWriter(path);
            for (String st : list) {
                fw.write(st);
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class Taker extends Thread {
    private Producer p;
    private List<Integer> taken = new ArrayList<Integer>();

    public Taker(String name, Producer p) {
        this.p = p;
        this.setName(name);
    }

    List<Integer> getTaken() {
        return taken;
    }

    @Override
    public void run() {
        while (true) {
            int count = p.count();
            if (count > LockTest.MAX_COUNT) {
                break;
            } else {
                taken.add(count);
            }
        }

    }
}

//非线程安全
class Producer {
    private Lock lock;
    private int count;
    private List<String> threadNames = new ArrayList<String>();

    public Producer(Lock lock) {
        this.lock = lock;
    }

    public int count() {
        int temp = 0;
        try {
            lock.lock();
            temp = count + 1;
            System.out.println(Thread.currentThread().getName() + "_taking_" + temp);
            threadNames.add("producer_" + Thread.currentThread().getName());
            count = temp;
        } finally {
            lock.unlock();
        }
        return temp;
    }

    public int now() {
        return count;
    }

    List<String> getThreadNames() {
        return threadNames;
    }
}

