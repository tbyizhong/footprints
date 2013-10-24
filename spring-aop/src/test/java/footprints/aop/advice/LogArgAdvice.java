package footprints.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-19
 * Time: 下午5:50
 */
public class LogArgAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("------------------------------------------");
        System.out.println("invoking " + method.getName() + ", args:");
        if (args != null) {
            for (Object obj : args) {
                System.out.println(obj);
            }
        }
        System.out.println("------------------------------------------");
    }
}
