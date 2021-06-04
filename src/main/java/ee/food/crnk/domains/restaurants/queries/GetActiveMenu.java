package ee.food.crnk.domains.restaurants.queries;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.queries.AbstractQuery;
import ee.food.crnk.resources.Menu;
import ee.food.crnk.resources.Restaurant;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepository;
import lombok.val;

import java.util.Arrays;

public class GetActiveMenu extends AbstractQuery {

    private final ResourceRepository<Menu, Object> menuRepository;
    private final Restaurant restaurant;
    private FoodeeClient client;

    public GetActiveMenu(FoodeeClient client, Restaurant restaurant) {
        this.client = client;
        this.menuRepository = client.getRepository(Menu.class);
        this.restaurant = restaurant;
    }

    public Menu invoke() {
        val querySpec = new QuerySpec(Menu.class);
        querySpec.includeRelation(Arrays.asList("menuGroups", "foodTypes"));
        querySpec.includeRelation(Arrays.asList("menuGroups", "mealTypes"));
        querySpec.includeRelation(Arrays.asList("menuGroups", "menuItems", "dietaryTags"));
        querySpec.includeRelation(Arrays.asList("menuGroups", "menuItems", "menuOptionGroups", "menuOptionItems", "dietaryTags"));
        return this.menuRepository.findOne(restaurant.getActiveMenu().getId(), querySpec);
    }
}
