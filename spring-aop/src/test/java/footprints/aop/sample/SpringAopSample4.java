package footprints.aop.sample;

import footprints.aop.service.HiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA. User: luoquan Date: 13-10-19 Time: 上午9:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean-sample4.xml")
public class SpringAopSample4 {
	@Autowired
	@Qualifier("hiService")
	private HiService hiService;

	@Test
	public void testAop() {
		hiService.sayHi("jack");

		hiService.sayHi("john");
	}


  @Test
  public void testAop2() {
      hiService.sayHello("rose");
  }
}
