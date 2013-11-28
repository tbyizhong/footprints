package footprints.proxy.callbacks;

import footprints.proxy.CacheImpl;
import net.sf.cglib.proxy.LazyLoader;

public class LazyLoadCache implements LazyLoader {

	@Override
	public Object loadObject() throws Exception {
		System.out.println("loading ...");
		return new CacheImpl();
	}

}
