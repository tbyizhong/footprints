package footprints.mybatis;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luoquan on 14-5-29.
 */
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    @Override
    public void createTable() {
        getJdbcTemplate().update("CREATE TABLE TBL_USERS(ID INTEGER, NAME VARCHAR(100), BIRTHDAY DATE);");
    }

    @Override
    @Transactional
    public void inser(User user) {
//        TransactionSynchronizationManager.hasResource(this);
//        TransactionSynchronizationManager.bindResource(this, "luoqauan");

//        TransactionSynchronizationManager.initSynchronization();
        TransactionSynchronizationManager.registerSynchronization(new TransactionListener());
        getJdbcTemplate().update("INSERT INTO TBL_USERS(ID, NAME, BIRTHDAY) VALUES ('" + user.getId() + "', '" + user.getName() + "', SYSDATE);");

//        error();

        getJdbcTemplate().update("INSERT INTO TBL_USERS(ID, NAME, BIRTHDAY) VALUES ('" + (user.getId()+1) + "', '" + user.getName() + "---', SYSDATE);");
    }

    @Override
    public void updateName(User user) {
        getJdbcTemplate().update("UPDATE TBL_USERS SET NAME='" + user.getName() + "' WHERE ID='" + user.getId() + "';");
    }
    @Override
    public void print() {
        getJdbcTemplate().query("select * from TBL_USERS", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println(rs.getString("name"));
            }
        });
    }

    @Override
    protected void initDao() throws Exception {
        createTable();
    }

    private void error() {
        throw new RuntimeException();
    }
}
