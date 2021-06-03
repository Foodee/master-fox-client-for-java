package ee.food.crnk.commands.orders;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.commands.AbstractCommand;
import ee.food.crnk.queries.GetClient;
import ee.food.crnk.queries.GetOrder;
import ee.food.crnk.queries.GetRestaurant;
import ee.food.crnk.resources.Area;
import ee.food.crnk.resources.Order;
import io.crnk.core.repository.ResourceRepository;
import lombok.Data;
import lombok.val;
import lombok.var;

import java.util.Calendar;
import java.util.Date;

public class PublishOrder extends AbstractCommand {

    private final ResourceRepository<Order, Object> orderRepository;
    private final GetOrder getOrder;
    private final Long orderId;

    public PublishOrder(FoodeeClient foodeeClient, Long orderId) {
        this.orderRepository = foodeeClient.getRepository(Order.class);
        this.getOrder = new GetOrder(foodeeClient, orderId);
        this.orderId = orderId;
    }

    public Order invoke() {
        var order = this.getOrder.invoke();

        logger.info(String.format("Publishing Order#%d", this.orderId));
        order.setStateEvent("publish");
        order = this.orderRepository.save(order);

        System.out.printf("Find the order at: https://app-staging.food.ee/team-order/%s%n", order.getUrlSafeId());

        return order;
    }


}
