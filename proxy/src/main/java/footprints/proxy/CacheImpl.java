package footprints.proxy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CacheImpl implements Cache {
	private Map<String, Object> map = new ConcurrentHashMap<String, Object>();
	private AtomicInteger hit = new AtomicInteger(0);
	private AtomicInteger miss = new AtomicInteger(0);
	private String desc;

	@Override
	public void put(String key, Object value) {
		map.put(key, value);
	}

	@Override
	public Object get(String key) {
		Object result = map.get(key);
		if (result == null) {
			miss.incrementAndGet();
		} else {
			hit.incrementAndGet();
		}
		return result;
	}
	
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
