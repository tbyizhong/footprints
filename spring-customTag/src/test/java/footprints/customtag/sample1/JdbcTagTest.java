package footprints.customtag.sample1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@ContextConfiguration(locations = "classpath:sample1.xml")
public class JdbcTagTest {
    @Autowired
    @Qualifier("defaultJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("testJdbcTemplate")
    private JdbcTemplate testJdbcTemplate;

    @Test
    public void testJdbc() {
        jdbcTemplate.update("CREATE TABLE USERS(ID INTEGER, NAME VARCHAR(100), BIRTHDAY DATE);");
        jdbcTemplate.update("INSERT INTO USERS(ID, NAME, BIRTHDAY) VALUES ('1', 'ADMIN', SYSDATE);");
        jdbcTemplate.query("select * from USERS", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println(rs.getString("name"));
            }
        });

        testJdbcTemplate.update("CREATE TABLE TEST_USERS(ID INTEGER, NAME VARCHAR(100), BIRTHDAY DATE);");
        testJdbcTemplate.update("INSERT INTO TEST_USERS(ID, NAME, BIRTHDAY) VALUES ('1', 'test_ADMIN', SYSDATE);");
        testJdbcTemplate.query("select * from TEST_USERS", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println(rs.getString("name"));
            }
        });
    }
}
