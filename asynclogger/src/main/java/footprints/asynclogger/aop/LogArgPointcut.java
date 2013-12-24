package footprints.asynclogger.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-12-23
 * Time: 上午11:14
 */
public class LogArgPointcut extends DynamicMethodMatcherPointcut {

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                System.out.println("static_" + clazz.getName());
                return true;
            }
        };

    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("static_" + method.getName());
        return true;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object[] args) {
        if (args != null && args.length > 0) {
            System.out.println("checking..." + args[0]);
            boolean result = "luoquan".equals(args[0]);
            if (result) {
                System.out.println("haha is ok");
            }
            return result;
        }
        return false;
    }
}
