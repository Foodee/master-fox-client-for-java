package ee.food.crnk.domains.ordering.commands;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.commands.AbstractCommand;
import ee.food.crnk.resources.GroupOrderMember;
import ee.food.crnk.resources.MenuItem;
import ee.food.crnk.resources.Order;
import ee.food.crnk.resources.OrderItem;
import io.crnk.core.repository.ResourceRepository;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreateOrderItem extends AbstractCommand<OrderItem> {

    private final FoodeeClient foodeeClient;
    private final Integer quantity;
    private Long orderId;
    private final Long menuItemId;
    private List<Long> menuOptionIds;
    private Optional<Long> groupOrderMemberId;
    private ResourceRepository<OrderItem, Object> orderItemRepository;

    public CreateOrderItem(FoodeeClient foodeeClient, Integer quantity, Long orderId, Long menuItemId, List<Long> menuOptionIds, Optional<Long> groupOrderMemberId) {
        this.foodeeClient = foodeeClient;
        this.quantity = quantity;
        this.orderId = orderId;
        this.menuItemId = menuItemId;
        this.menuOptionIds = menuOptionIds;
        this.groupOrderMemberId = groupOrderMemberId;
        this.init();
    }

    public CreateOrderItem(FoodeeClient foodeeClient, Integer quantity, Long orderId, Long menuItemId) {
        this(foodeeClient, quantity, orderId, menuItemId, new ArrayList<>(), Optional.empty());
    }

    public CreateOrderItem(FoodeeClient foodeeClient, Integer quantity, Long orderId, Long menuItemId, Long groupOrderMemberId) {
        this(foodeeClient, quantity, orderId, menuItemId, new ArrayList<>(), Optional.of(groupOrderMemberId));
    }

    public CreateOrderItem(FoodeeClient foodeeClient, Integer quantity, Long orderId, Long menuItemId, List<Long> menuOptionIds, Long groupOrderMemberId) {
        this(foodeeClient, quantity, orderId, menuItemId, menuOptionIds, Optional.of(groupOrderMemberId));
    }

    private void init() {
        this.orderItemRepository = foodeeClient.getRepository(OrderItem.class);
    }

    public OrderItem invoke() {
        val orderItem = new OrderItem();

        orderItem.setMenuItem(MenuItem.id(this.menuItemId));
        orderItem.setOrder(Order.id(this.orderId));
        orderItem.setQuantity(this.quantity);

        this.groupOrderMemberId.ifPresent(aLong -> orderItem.setGroupOrderMember(GroupOrderMember.id(aLong)));

        logger.info("Creating OrderItem for MenuItem " + this.menuItemId);


        val createdOrderItem = this.orderItemRepository.create(orderItem);

        //  TODO do some stuff with options

        return createdOrderItem;
    }

}
