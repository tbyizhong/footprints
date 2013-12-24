package footprints.aop;

import footprints.aop.advice.Controllable;
import footprints.aop.service.HiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-19
 * Time: 上午9:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean-aop.xml")
public class SpringAopTest {
    @Autowired
    @Qualifier("hiServiceProxy")
    private HiService hiService;
    @Test
    public void testAop() {
        hiService.sayHi("jack");

        Controllable c = (Controllable)hiService;
        c.stop();
        hiService.sayHi("john");

        c.start();
        hiService.sayHi("jack");

    }

//    @Test
//    public void testAop2() {
//        hiService.sayHello("jack");
//    }

}
