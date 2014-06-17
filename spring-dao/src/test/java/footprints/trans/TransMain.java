package footprints.trans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by luoquan on 14-5-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:hi.xml","classpath:bean-persistence.xml"})
public class TransMain {
    @Resource
    private HelloDao helloDao;

    @Test
    public  void testmain() {
        helloDao.saveHello();
    }
}
