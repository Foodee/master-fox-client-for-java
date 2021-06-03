package ee.food.crnk.domains.areas.queries;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.queries.AbstractQuery;
import ee.food.crnk.resources.Area;
import io.crnk.core.queryspec.FilterOperator;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.resource.list.ResourceList;
import lombok.val;

import java.util.Arrays;

public class GetActiveAreas extends AbstractQuery {

    private FoodeeClient foodeeClient;

    public GetActiveAreas(FoodeeClient foodeeClient) {
        this.foodeeClient = foodeeClient;
    }

    public ResourceList<Area> invoke() {
        val restaurantRepository = foodeeClient.getRepository(Area.class);
        QuerySpec querySpec = new QuerySpec(Area.class);
        querySpec.addFilter(PathSpec.of("active").filter(FilterOperator.EQ, true));
        querySpec.includeRelation(Arrays.asList("activeMenu"));

        return restaurantRepository.findAll(querySpec);
    }
}
