package footprints.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-24
 * Time: 上午10:01
 */
public class LogExeTimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;
        long start = System.currentTimeMillis();
        try {
            result = invocation.proceed();
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("\n------------------------------------------");
            System.out.println(invocation.getMethod() + " execution costs " + (end - start) + " ms");
            System.out.println("------------------------------------------\n");
        }
        return result;
    }
}
