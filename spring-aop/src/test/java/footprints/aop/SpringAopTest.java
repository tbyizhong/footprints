package footprints.aop;

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
    @Qualifier("logArgProxy")
    private HiService hiService;
    @Test
    public void testAop() {
        hiService.sayHi("jack");
    }

    @Test
    public void testAop2() {
        hiService.sayHello("jack");
    }

}
