package footprints.aop.proxy.jdk;

import footprints.aop.service.HiService;
import footprints.aop.service.HiServiceImpl;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-22
 * Time: 下午10:27
 */
public class LogPerfUtil {
    public static <I, T extends I> I logPerf(T target, Class<I> clazz) {
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new LogPerfHandler(target));

        return (I)proxy;
    }
}
