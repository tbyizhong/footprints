package footprints.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created by luoquan on 14-5-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean-persistence.xml")
public class UserTest {
    @Autowired
    private UserDao userDao;


    @Test
    public void testUser(){



        User user = new User(100000, "luoquan");
        try {
            userDao.inser(user);
        } catch (Exception e) {

        }
        userDao.print();

        user.setName("yizhong");
        userDao.updateName(user);

        userDao.print();
    }
}
