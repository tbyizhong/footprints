package footprints.customtag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-19
 * Time: 上午9:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean-persistence.xml")
public class SpringDaoTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbc() {
        jdbcTemplate.update("CREATE TABLE TBL_USERS(ID INTEGER, NAME VARCHAR(100), BIRTHDAY DATE);");
        jdbcTemplate.update("INSERT INTO TBL_USERS(ID, NAME, BIRTHDAY) VALUES ('1', 'ADMIN', SYSDATE);");
        jdbcTemplate.query("select * from TBL_USERS", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println(rs.getString("name"));
            }
        });
    }
}
