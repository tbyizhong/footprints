package footprints.aop.proxy.jdk;

import footprints.aop.service.HiService;
import footprints.aop.service.HiServiceImpl;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-22
 * Time: 下午10:15
 */
public class JdkProxyTest {
    @Test
    public void testHiService() {
        HiService hiService = new HiServiceImpl();
        hiService.sayHello("jack");
    }

    @Test
    public void testProxyHiService() {
        HiService hiService = new HiServiceImpl();
        HiService proxy =(HiService) Proxy.newProxyInstance(
                hiService.getClass().getClassLoader(),
                hiService.getClass().getInterfaces(),
                new LogPerfHandler(hiService));

        proxy.sayHello("jack");
    }

    @Test
    public void testLogPerfUtil() {
        HiServiceImpl hiService = new HiServiceImpl();
        HiService hi = LogPerfUtil.logPerf(hiService, HiService.class);

        hi.sayHello("jack");
    }
}
