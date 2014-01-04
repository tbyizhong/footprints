package footprints.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 14-1-4
 * Time: 下午3:38
 */
public class OrderServiceImpl implements OrderService {
    private Map<Long, Order> storage = new HashMap<Long, Order>();

    @Override
    @Caching(cacheable={@Cacheable(value="default"),@Cacheable(value="orderCache") })
    public Order getOrderById(long id) {
        Order order = storage.get(id);
        System.out.println("getOrderById,id:" + id + ",result:" + order);
        return order;
    }

    @Override
    @Cacheable("default")
    public List<Order> getOrdersByName(String name) {
        List<Order> result = new ArrayList<Order>();

        if (name == null || "".equals(name)) {
            return result;
        }

        for (Map.Entry<Long, Order> e : storage.entrySet()) {
            if (e.getValue().getName().contains(name)) {
                result.add(e.getValue());
            }
        }

        System.out.println("getOrdersByName,name:" + name + ",result:" + result);
        return result;
    }

    @Override
    @CacheEvict(value="default", key="#order.id")
    public int updateOrder(Order order) {
        if (order == null || order.getId() <= 0 || order.getName() == null || "".equals(order.getName())) {
            System.out.println("updateOrder,order:" + order + ",result:0");
            return 0;
        }

        storage.put(order.getId(), order);
        System.out.println("updateOrder,order:" + order + ",result:1");
        return 1;
    }

    @Override
    public int saveOrder(Order order) {
        if (order == null || order.getId() <= 0 || order.getName() == null || "".equals(order.getName())) {
            System.out.println("saveOrder,order:" + order + ",result:0");
            return 0;
        }

        storage.put(order.getId(), order);
        System.out.println("saveOrder,order:" + order + ",result:1");
        return 1;
    }
}
