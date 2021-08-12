package ee.food.crnk;

import ee.food.crnk.domains.clients.queries.GetClient;
import ee.food.crnk.domains.ordering.OrderState;
import ee.food.crnk.domains.ordering.commands.CreateGroupOrderMember;
import ee.food.crnk.domains.ordering.commands.CreateOrder;
import ee.food.crnk.domains.ordering.commands.CreateOrderItem;
import ee.food.crnk.domains.ordering.commands.PublishOrder;
import ee.food.crnk.domains.ordering.queries.GetClientOrders;
import ee.food.crnk.domains.restaurants.queries.GetActiveMenu;
import ee.food.crnk.domains.restaurants.queries.GetActiveRestaurants;
import ee.food.crnk.resources.Menu;
import ee.food.crnk.resources.Order;
import ee.food.crnk.resources.Restaurant;
import io.crnk.core.resource.list.ResourceList;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.Date;

public class Exercise {

    public static void main(String[] args) {
        // Staging
        FoodeeClient foodeeClient = new FoodeeClient("https://api-staging.food.ee", "8SMJ3XuneAsavFx7VTxujTeGY3oGtXKTHrm03HBz/W52z+SlctRwuUKUW8g=");

        // Returns the client account that this api k is attached to
        long clientId = 22347L;
        val aClient = new GetClient(foodeeClient, clientId).invoke();

        //  Returns the orders that are ready to be ordered from for this client (ie: in group building)
        //  this should come down with the menu on the order as well
        val orders = new GetClientOrders(foodeeClient, clientId, OrderState.GROUP_BUILDING).invoke();

        System.out.printf("Found %d Orders%n", orders.size());
    }

    private static void listRestaurantsAndCreateAnOrder(FoodeeClient foodeeClient) {
        // NOTE: If you encounter a capacity error while exercising this endpoint
        // change the array index
        ResourceList<Restaurant> all = new GetActiveRestaurants(foodeeClient).invoke();
        printAllRestaurants(foodeeClient, all);
        val restaurant = (Restaurant) all.toArray()[10];
        runCreateOrder(foodeeClient, restaurant);
    }

    private static void runCreateOrder(FoodeeClient foodeeClient, Restaurant restaurant) {
        final Order publishedOrder = publishOrder(foodeeClient, restaurant);

        val gom = new CreateGroupOrderMember(foodeeClient, publishedOrder.getId(), "Test Person", "test@test.com").invoke();
        val menuItem = restaurant.getActiveMenu().getMenuItems().stream().findFirst().get();
        val orderItem = new CreateOrderItem(foodeeClient, 1, publishedOrder.getId(), menuItem.getId(), gom.getId()).invoke();
    }

    @NotNull
    private static Order publishOrder(FoodeeClient foodeeClient, Restaurant restaurant) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 34);

        val basicOrderParams = new CreateOrder.BasicOrderParams(
                1L,
                22347L,
                restaurant.getId(),
                20,
                "Test Event",
                calendar.getTime()
        );
        val createdOrder = new CreateOrder(foodeeClient, basicOrderParams).invoke();
        System.out.println(createdOrder.getId());

        val publishedOrder = new PublishOrder(foodeeClient, createdOrder.getId()).invoke();
        System.out.println(publishedOrder.getState());
        return publishedOrder;
    }

    private static void printAllRestaurants(FoodeeClient foodeeClient, ResourceList<Restaurant> all) {
        for (Restaurant restaurant : all) {
            System.out.println("Restaurant#" + restaurant.getId() + " - " + restaurant.getName());
            System.out.println("Thumbnail " + restaurant.getThumbnailImageUrl());
            Menu activeMenu = new GetActiveMenu(foodeeClient, restaurant).invoke();
            Utils.printMenu(activeMenu);
        }
    }
}
