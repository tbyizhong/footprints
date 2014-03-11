package footprints.disruptor;

public class Order {
    public static int count =0;
	public String id;

    public Order() {
        System.out.println("Order created:" + (++count));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id："+id;
    }
}