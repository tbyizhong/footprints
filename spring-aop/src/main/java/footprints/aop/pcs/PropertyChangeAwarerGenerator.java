package footprints.aop.pcs;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-23
 * Time: 下午10:28
 */
public class PropertyChangeAwarerGenerator {
    private PropertyChangeSupport pcs;
    private PropertyChangeListener listener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            System.out.println(evt.getPropertyName() + "-" + evt.getOldValue() + "-" + evt.getNewValue());
        }
    };

    public PropertyChangeAwarerGenerator() {

    }

    public <T> T genPropertyChangeAwareObj(final Class<T> clazz) {
        Enhancer en = new Enhancer();
        en.setSuperclass(clazz);

        en.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                try {
                    String mName = method.getName();
                    if (mName.startsWith("set") && objects.length == 1) {
                        String temp = mName.substring(3);
                        String pName = temp.substring(0, 1).toLowerCase() + temp.substring(1);

                        Method getter = clazz.getMethod("get" + temp, new Class[]{});
                        Object old = getter.invoke(o, new Object[]{});
                        pcs.firePropertyChange(pName,old , objects[0]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Object result = methodProxy.invokeSuper(o, objects);
                return result;
            }
        });

        T obj = (T) en.create();
        pcs = new PropertyChangeSupport(obj);
        pcs.addPropertyChangeListener(listener);
        return obj;
    }
}
