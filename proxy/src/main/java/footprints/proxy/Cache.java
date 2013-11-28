package footprints.proxy;

public interface Cache {
	void put(String key, Object value);
	Object get(String key);
}
