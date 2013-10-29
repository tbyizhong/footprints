package footprints.aop.service;

import java.util.Random;

import org.springframework.cache.annotation.Cacheable;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-19
 * Time: 下午5:46
 */
public class HiServiceImpl implements HiService {
    @Override
    public String sayHi(String name) {
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hi, " + name);
        return "hi, " + name;
    }

    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
            System.out.println("hello, " + name);
//            throw new IllegalArgumentException("...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello, " + name;
    }
}
