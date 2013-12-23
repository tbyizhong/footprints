package footprints.aop.proxy.cglib;

import footprints.aop.service.HiServiceImpl;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-22
 * Time: 下午10:48
 */
public class CglibProxyTest {
    @Test
    public void testCglib(){

        Enhancer en = new Enhancer();
        en.setSuperclass(HiServiceImpl.class);
        en.setCallback(new MethodInterceptor(){
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long start = System.currentTimeMillis();
                Object result = methodProxy.invokeSuper(o, objects);
                long end = System.currentTimeMillis();
                System.out.println(method.getName() + " cost " + (end-start) + " ms");

                return result;
            }
        });

        HiServiceImpl hi = (HiServiceImpl)en.create();
        hi.sayHello("jack");

    }
}
