package ee.food.crnk;

import ee.food.crnk.domains.ordering.commands.CreateGroupOrderMember;
import ee.food.crnk.domains.ordering.commands.CreateOrder;
import ee.food.crnk.domains.ordering.commands.CreateOrderItem;
import ee.food.crnk.domains.ordering.commands.PublishOrder;
import ee.food.crnk.domains.restaurants.queries.GetActiveMenu;
import ee.food.crnk.domains.restaurants.queries.GetActiveRestaurants;
import ee.food.crnk.resources.Menu;
import ee.food.crnk.resources.Restaurant;
import io.crnk.core.resource.list.ResourceList;
import lombok.val;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class Exercise {

    public static void main(String[] args) {
        // TODO parametrize this

        // Staging
        FoodeeClient foodeeClient = new FoodeeClient("https://api-staging.food.ee", "8SMJ3XuneAsavFx7VTxujTeGY3oGtXKTHrm03HBz/W52z+SlctRwuUKUW8g=");
//         LocalHost
//         FoodeeClient foodeeClient = new FoodeeClient("http://localhost:3000", "So16OMcJfVRm1lEyWqLOqT4jnh6xrQpYvU8gLEj+gLiZPWIPKw9wB00=");
        ResourceList<Restaurant> all = new GetActiveRestaurants(foodeeClient).invoke();
//        printAllRestaurants(foodeeClient, all);


        // NOTE: If you encounter a capacity error while exercising this endpoint
        // change the array index
        val restaurant = (Restaurant) all.toArray()[10];

        runCreateOrder(foodeeClient, restaurant);
    }

    private static void runCreateOrder(FoodeeClient foodeeClient, Restaurant restaurant) {
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

        val gom = new CreateGroupOrderMember(foodeeClient, publishedOrder.getId(), "Test Person", "test@test.com").invoke();
        val menuItem = restaurant.getActiveMenu().getMenuItems().stream().findFirst().get();
        val orderItem = new CreateOrderItem(foodeeClient, 1, publishedOrder.getId(), menuItem.getId(), gom.getId()).invoke();
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
