package footprints.cache;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 14-1-4
 * Time: 下午3:34
 */
public class Order {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "-" + name;
    }
}
