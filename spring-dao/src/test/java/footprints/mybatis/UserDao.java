package footprints.mybatis;

/**
 * Created by luoquan on 14-5-29.
 */
public interface UserDao {
    void createTable();

    void inser(User user);

    void updateName(User user);

    void print();
}
