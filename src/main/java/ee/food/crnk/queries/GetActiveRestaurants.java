package ee.food.crnk.queries;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.resources.Restaurant;
import io.crnk.core.queryspec.FilterOperator;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.resource.list.ResourceList;
import lombok.val;

import java.util.Arrays;

public class GetActiveRestaurants extends AbstractQuery {

    private FoodeeClient client;

    public GetActiveRestaurants(FoodeeClient client) {
        this.client = client;
    }

    public ResourceList<Restaurant> invoke() {
        val restaurantRepository = client.getRepository(Restaurant.class);
        QuerySpec querySpec = new QuerySpec(Restaurant.class);
        querySpec.addFilter(PathSpec.of("active").filter(FilterOperator.EQ, true));
        querySpec.includeRelation(Arrays.asList("activeMenu"));

        return restaurantRepository.findAll(querySpec);
    }
}
