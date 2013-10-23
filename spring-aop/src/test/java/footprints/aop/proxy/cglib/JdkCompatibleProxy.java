package footprints.aop.proxy.cglib;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/***
 * This class is meant to be used as a drop-in replacement for
 * <code>java.lang.reflect.Proxy</code>.
 * There are some known subtle differences:
 * <ul>
 * <li>The exceptions returned by invoking <code>getExceptionTypes</code>
 * on the <code>Method</code> passed to the <code>invoke</code> method
 * <b>are</b> the exact set that can be thrown without resulting in an
 * <code>UndeclaredThrowableException</code> being thrown.
 * <li>There is no protected constructor which accepts an
 * <code>InvocationHandler</code>. Instead, use the more convenient
 * <code>newProxyInstance</code> static method.
 * <li><code>net.sf.cglib.UndeclaredThrowableException</code> is used instead
 * of <code>java.lang.reflect.UndeclaredThrowableException</code>.
 * </ul> 
 * @author Chris Nokleberg <a href="mailto:chris@nokleberg.com">chris@nokleberg.com</a>
 * @version $Id: JdkCompatibleProxy.java,v 1.3 2003/01/24 00:27:44 herbyderby Exp $
 */
public class JdkCompatibleProxy implements Serializable {
    private static final Class thisClass = JdkCompatibleProxy.class;
    private static final HandlerAdapter nullInterceptor = new HandlerAdapter(null);
    private static Map generatedClasses = Collections.synchronizedMap( new WeakHashMap() );

    private static class HandlerAdapter implements MethodInterceptor {
        private InvocationHandler handler;
        public HandlerAdapter(InvocationHandler handler) {
            this.handler = handler;
        }

        public Object aroundAdvice(Object obj, Method method, Object[] args,
                                   MethodProxy proxy) throws Throwable {
            return handler.invoke(obj, method, args);
        }
    }

    protected JdkCompatibleProxy() {
    }

    public static InvocationHandler getInvocationHandler(Object proxy) {
        return ((HandlerAdapter)((Factory)proxy).getInterceptor()).handler;
    }

    public static Class getProxyClass(ClassLoader loader, Class[] interfaces) {
        Class cls = Enhancer.enhance(thisClass, interfaces, nullInterceptor, loader).getClass();
        generatedClasses.put(cls, null);
        return cls;
    }

    public static boolean isProxyClass(Class cl) {
        return generatedClasses.containsKey(cl);
    }

    public static Object newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h) {
        Object obj = Enhancer.enhance(thisClass, interfaces, new HandlerAdapter(h), loader);
        generatedClasses.put(obj.getClass(), null);
        return obj;
    }        
}
