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
@ContextConfiguration(locations = "classpath:bean-sample1.xml")
public class SpringAopSample1 {
	@Autowired
	@Qualifier("hiServiceProxy")
	private HiService hiService;
	
	@Autowired
	@Qualifier("hiServiceProxy")
	private HiService hiService2;
	
	
	@Autowired
	@Qualifier("hiService")
	private HiService hiService3;
	
	@Test
	public void testEquals() {
		System.out.println(hiService);
		System.out.println(hiService2);
		System.out.println(hiService3);
		
		hiService.sayHi("jack");
		hiService2.sayHi("jack");
		hiService3.sayHi("jack");
		
		
		System.out.println(hiService2==hiService);
		System.out.println(hiService3==hiService);
		System.out.println(hiService2==hiService3);
		
		System.out.println(hiService.equals(hiService2));
	}

//	@Test
//	public void testAop() {
//		hiService.sayHi("jack");
//
//		hiService.sayHi("john");
//	}
//
//
//  @Test
//  public void testAop2() {
//      hiService.sayHello("rose");
//  }
}
