package footprints.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 14-1-4
 * Time: 下午3:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean-cache.xml"})
public class OrderServiceTest implements ApplicationContextAware {
    @Autowired
    private OrderService orderService;

    private ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }

    @Test
    public void testOrderService() {
        Order order = new Order();
        order.setId(100000);
        order.setName("aaaaaaaa");

        orderService.saveOrder(order);


        order = new Order();
        order.setId(200000);
        order.setName("bbbbaabbbb");

        orderService.saveOrder(order);


        order = orderService.getOrderById(100000);

        order.setName(order.getName()+"_hi");
        orderService.updateOrder(order);

        order = orderService.getOrderById(100000);

        List<Order> orderList = orderService.getOrdersByName("aa");

        orderList = orderService.getOrdersByName("aa");


        SimpleCacheManager cacheManager = (SimpleCacheManager) ac.getBean("cacheManager");
        ConcurrentMapCache ccccc = (ConcurrentMapCache) cacheManager.getCache("default");
        System.out.println(ccccc.getNativeCache());

        ccccc = (ConcurrentMapCache) cacheManager.getCache("orderCache");
        System.out.println(ccccc.getNativeCache());
    }
}