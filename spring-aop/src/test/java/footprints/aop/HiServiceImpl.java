package footprints.aop;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-19
 * Time: 下午5:46
 */
public class HiServiceImpl implements HiService {
    @Override
    public void sayHi(String name) {
        System.out.println("hi, " + name);
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello, " + name);
    }
}
