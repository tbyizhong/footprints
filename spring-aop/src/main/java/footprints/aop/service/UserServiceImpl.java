package footprints.aop.service;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-30
 * Time: 上午7:06
 */
public class UserServiceImpl implements UserService {
    @Override
    public String sayHi(String name) {

        return "user:" + name;
    }

    @Override
    public boolean userNameExists(String name) {
        return false;
    }
}
