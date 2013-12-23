package footprints.aop.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-24
 * Time: 上午11:34
 */
public class ControllableLogExeTimeAdvice extends DelegatingIntroductionInterceptor implements Controllable {
    private boolean on = true;

    @Override
    public void stop() {
        on = false;
    }

    @Override
    public void start() {
        on = true;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object result = super.invoke(mi);
        if (on) {
            System.out.println("------------------------------------------");
            Method method = mi.getMethod();
            Object[] args = mi.getArguments();
            System.out.println("invoking " + method.getName() + ", arguments:");
            if (args != null) {
                for (Object obj : args) {
                    System.out.println(obj);
                }
            }
            System.out.println("------------------------------------------");
        }
        return result;
    }
}
