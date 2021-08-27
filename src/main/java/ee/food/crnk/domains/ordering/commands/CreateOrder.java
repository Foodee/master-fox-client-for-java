package ee.food.crnk.domains.ordering.commands;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.commands.AbstractCommand;
import ee.food.crnk.domains.clients.queries.GetClient;
import ee.food.crnk.domains.restaurants.queries.GetRestaurant;
import ee.food.crnk.resources.Area;
import ee.food.crnk.resources.Order;
import io.crnk.core.repository.ResourceRepository;
import lombok.Data;
import lombok.val;
import lombok.var;

import java.util.Calendar;
import java.util.Date;

public class CreateOrder extends AbstractCommand<Order> {

    private final ResourceRepository<Order, Object> orderRepository;
    private final BasicOrderParams basicOrderParams;
    private final GetClient getClient;
    private final GetRestaurant getRestaurant;
    private FoodeeClient foodeeClient;

    @Data
    public static class BasicOrderParams {
        private Long areaId;
        private Long clientId;
        private Long restaurantId;
        private Date pickupAt;
        private Date deliverAt;
        private Date deadlineAt;
        private Integer numberOfPeople;
        private String eventName;
        private Float perPersonBudget;

        public BasicOrderParams(Long areaId, Long clientId, Long restaurantId, Integer numberOfPeople, String eventName, Date deliverAt, Float perPersonBudget) {
            this.areaId = areaId;
            this.clientId = clientId;
            this.restaurantId = restaurantId;
            this.numberOfPeople = numberOfPeople;
            this.eventName = eventName;
            this.deliverAt = deliverAt;

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(deliverAt);
            calendar.add(Calendar.MINUTE, -30);
            this.pickupAt = calendar.getTime();

            calendar.setTime(deliverAt);
            calendar.add(Calendar.HOUR, -2);
            this.deadlineAt = calendar.getTime();
            this.perPersonBudget = perPersonBudget;
        }
    }

    public CreateOrder(FoodeeClient foodeeClient, BasicOrderParams basicOrderParams) {
        this.foodeeClient = foodeeClient;
        this.orderRepository = foodeeClient.getRepository(Order.class);
        this.basicOrderParams = basicOrderParams;

        this.getClient = new GetClient(foodeeClient, this.basicOrderParams.clientId);
        this.getRestaurant = new GetRestaurant(foodeeClient, this.basicOrderParams.restaurantId);
    }

    public Order invoke() {
        var order = new Order();

        logger.info("Creating Order with the following params");
        logger.info(this.basicOrderParams.toString());

        val client = this.getClient.invoke();
        val restaurant = this.getRestaurant.invoke();

        order.setDeadlineAt(basicOrderParams.deadlineAt);
        order.setPickupAt(basicOrderParams.pickupAt);
        order.setDeliverAt(basicOrderParams.deliverAt);
        order.setName(basicOrderParams.eventName);
        order.setNumberOfPeople(basicOrderParams.numberOfPeople);
        order.setPerPersonBudget(basicOrderParams.perPersonBudget);

        order.setAllowsGuests(true);
        order.setArea(Area.id(basicOrderParams.areaId));
        order.setClient(client);
        order.setRestaurant(restaurant);
        order.setOwner(client.getOwner());

        // These are unsafe
        order.setClientLocation(client.getDeliveryLocations().stream().findFirst().get().getLocation());
        order.setRestaurantLocation(restaurant.getPickupLocations().stream().findFirst().get().getLocation());
        order = orderRepository.create(order);
        System.out.printf("Find the order at: https://app-staging.food.ee/team-order/%s%n", order.getUrlSafeId());
        System.out.printf("Find the order at: https://concierge-staging.food.ee/starfox/orders/%s%n", order.getId());

        return order;
    }


}
