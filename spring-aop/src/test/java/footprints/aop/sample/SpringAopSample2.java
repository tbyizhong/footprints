package footprints.aop.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import footprints.aop.service.HiService;

/**
 * Created with IntelliJ IDEA. User: luoquan Date: 13-10-19 Time: 上午9:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean-sample2.xml")
public class SpringAopSample2 {
	@Autowired
	@Qualifier("hiServiceProxy")
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
