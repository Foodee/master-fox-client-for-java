package ee.food.crnk.queries;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.resources.Restaurant;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepository;
import lombok.val;

import java.util.Arrays;

public class GetRestaurant extends AbstractQuery {

    private final ResourceRepository<Restaurant, Object> restaurantRepository;
    private Long restaurantId;
    private FoodeeClient client;

    public GetRestaurant(FoodeeClient client, Long restaurantId) {
        this.client = client;
        this.restaurantRepository = client.getRepository(Restaurant.class);
        this.restaurantId = restaurantId;
    }

    public Restaurant invoke() {
        val querySpec = new QuerySpec(Restaurant.class);
        querySpec.includeRelation(Arrays.asList("pickupLocations", "location"));
        return this.restaurantRepository.findOne(restaurantId, querySpec);
    }
}
