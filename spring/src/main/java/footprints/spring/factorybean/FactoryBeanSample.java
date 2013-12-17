package footprints.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;


public class FactoryBeanSample implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		System.out.println("----------getObject-----------");
		return new User();
	}

	@Override
	public Class<User> getObjectType() {
		return User.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}

