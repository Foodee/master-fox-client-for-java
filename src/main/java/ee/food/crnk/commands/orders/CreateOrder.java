package ee.food.crnk.commands.orders;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.commands.AbstractCommand;
import ee.food.crnk.queries.GetClient;
import ee.food.crnk.queries.GetRestaurant;
import ee.food.crnk.resources.Area;
import ee.food.crnk.resources.Client;
import ee.food.crnk.resources.Order;
import ee.food.crnk.resources.Restaurant;
import io.crnk.core.repository.ResourceRepository;
import lombok.Data;
import lombok.val;
import lombok.var;

import java.util.Calendar;
import java.util.Date;

public class CreateOrder extends AbstractCommand {

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

        public BasicOrderParams(Long areaId, Long clientId, Long restaurantId, Integer numberOfPeople, String eventName, Date deliverAt) {
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

        order.setDeadlineAt(basicOrderParams.pickupAt);
        order.setPickupAt(basicOrderParams.deliverAt);
        order.setDeliverAt(basicOrderParams.deadlineAt);
        order.setName(basicOrderParams.eventName);
        order.setNumberOfPeople(basicOrderParams.numberOfPeople);
        order.setPerPersonBudget(2000.00f);

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

        return order;
    }


}
