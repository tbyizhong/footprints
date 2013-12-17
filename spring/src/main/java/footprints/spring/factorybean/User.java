package footprints.spring.factorybean;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
	private static final AtomicInteger count = new AtomicInteger(0);
	private String name;

	public User() {
		System.out.println("User" + count.incrementAndGet() + " init...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}