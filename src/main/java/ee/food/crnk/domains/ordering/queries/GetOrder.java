package ee.food.crnk.domains.ordering.queries;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.queries.AbstractQuery;
import ee.food.crnk.resources.Order;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepository;
import lombok.val;

public class GetOrder extends AbstractQuery {

    private Long orderId;
    private final ResourceRepository<Order, Object> orderRepository;
    private FoodeeClient order;

    public GetOrder(FoodeeClient order, Long orderId) {
        this.order = order;
        this.orderRepository = order.getRepository(Order.class);
        this.orderId = orderId;
    }

    public Order invoke() {
        return this.orderRepository.findOne(orderId, new QuerySpec(Order.class));
    }
}
