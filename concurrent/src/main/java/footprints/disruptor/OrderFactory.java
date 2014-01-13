package footprints.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Administrator on 14-1-10.
 */
public class OrderFactory implements EventFactory<Order> {
    @Override
    public Order newInstance() {
        return new Order();
    }
}
