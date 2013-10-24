package footprints.aop.service;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-19
 * Time: 下午5:46
 */
public class HiServiceImpl implements HiService {
    @Override
    public void sayHi(String name) {
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hi, " + name);
    }

    @Override
    public void sayHello(String name) {
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
            throw new IllegalArgumentException("...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello, " + name);
    }
}
