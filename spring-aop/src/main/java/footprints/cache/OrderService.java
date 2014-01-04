package footprints.cache;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 14-1-4
 * Time: 下午3:35
 */
public interface OrderService {
    Order getOrderById(long id);

    List<Order> getOrdersByName(String name);

    int updateOrder(Order order);

    int saveOrder(Order order);
}
