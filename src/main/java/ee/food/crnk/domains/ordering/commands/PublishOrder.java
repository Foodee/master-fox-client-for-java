package ee.food.crnk.domains.ordering.commands;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.commands.AbstractCommand;
import ee.food.crnk.domains.ordering.queries.GetOrder;
import ee.food.crnk.resources.Order;
import io.crnk.core.repository.ResourceRepository;
import lombok.var;

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
