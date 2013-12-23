package footprints.aop.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-24
 * Time: 上午9:58
 */
public class LogResultAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("\n------------------------------------------");
        System.out.println("invoking " + method.getName() + ", result:" + returnValue);
        System.out.println("------------------------------------------\n");
    }
}
