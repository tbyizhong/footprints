package footprints.aop.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-24
 * Time: 上午9:59
 */
public class LogExceptionAdvice implements ThrowsAdvice {
    public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
        System.out.println("\n------------------------------------------");
        System.out.println("invoking " + method.getName() + ", throws an exception:");
        e.printStackTrace();
        System.out.println("------------------------------------------\n");
    }
}
