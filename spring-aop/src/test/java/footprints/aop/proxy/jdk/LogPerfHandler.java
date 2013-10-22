package footprints.aop.proxy.jdk;

import footprints.aop.service.HiService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-22
 * Time: 下午10:12
 */
public class LogPerfHandler implements InvocationHandler {
    private Object target;

    public LogPerfHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println(method.getName() + " cost " + (end-start) + " ms");
        return result;
    }
}
