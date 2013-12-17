package footprints.spring.factorybean;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA. User: luoquan Date: 13-10-19 Time: 上午9:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean-factorybean.xml")
public class FactoryBeanTest {
	@Resource
	private User users;
	
	
	@Resource
	private User users2;

	@Test
	public void testFactoryBean() {
		System.out.println(users.getName());
		System.out.println(users.equals(users2));
	}
}
