package footprints.aop.pcs;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-23
 * Time: 下午10:22
 */
public class UserTest {
    public static void main(String[] args) {
        User u = new PropertyChangeAwarerGenerator().genPropertyChangeAwareObj(User.class);
        u.setName("jack");
        u.setAge(2323);
        u.setName("john");
        u.setAge(1234);
    }
}
