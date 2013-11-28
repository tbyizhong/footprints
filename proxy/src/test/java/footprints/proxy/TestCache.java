package footprints.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;

import org.junit.Ignore;
import org.junit.Test;

import footprints.proxy.callbacks.LazyLoadCache;
import footprints.proxy.callbacks.LogArgInterceptor;
import footprints.proxy.callbacks.MockCache;

public class TestCache {
	// @Test
	// public void testProxyInterfaceCache() {
	// Enhancer en = new Enhancer();
	// en.setInterfaces(new Class[] { Cache.class });
	// en.setCallback(new LogArgInterceptor());
	// Cache c = (Cache) en.create();
	// c.put("testkey", "testvalue");
	// c.get("hi");
	// }

	@Test @Ignore
	public void testProxyCache() {
		Enhancer en = new Enhancer();
		en.setSuperclass(CacheImpl.class);
		// en.setCallback(new LogArgInterceptor());
		en.setCallbacks(new Callback[] { new LogArgInterceptor(),
				new MockCache() });
		
		en.setCallbackFilter(new CallbackFilter() {
			
			@Override
			public int accept(Method method) {
				if ("get".equals(method.getName())) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		CacheImpl c = (CacheImpl) en.create();
		c.put("testkey", "testvalue");
		Object value = c.get("testkey");
		System.out.println(value);
	}
	
	private Cache cache;
	@Test
	public void testLazyloadCache() {
		TestCache tc = new TestCache();
		CacheImpl c = (CacheImpl) Enhancer.create(CacheImpl.class, new LazyLoadCache());
		System.out.println("====start===");
		tc.cache = c; 
		System.out.println("===end====");
		c.put("testkey", "testvalue");
		Object value = c.get("testkey");
		System.out.println(value);
	}
}
