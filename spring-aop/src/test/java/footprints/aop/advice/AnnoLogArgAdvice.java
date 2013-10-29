package footprints.aop.advice;

import java.lang.reflect.Method;

import org.aspectj.lang.annotation.AfterReturning;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.aspectj.lang.annotation.Pointcut;  

@Aspect
public class AnnoLogArgAdvice {
	@Pointcut("execution(* *.sayHi(java.lang.String))")
	public void hi(){}

	@Before("hi()")
	public void bef() {
		System.out.println("-----");
	}
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
