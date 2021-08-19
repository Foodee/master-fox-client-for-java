package ee.food.crnk.domains.restaurants.queries;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.queries.AbstractQuery;
import ee.food.crnk.resources.DietaryTag;
import ee.food.crnk.resources.Restaurant;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepository;
import io.crnk.core.resource.list.ResourceList;
import lombok.val;

public class GetAllDietaryTags extends AbstractQuery {

    private final ResourceRepository<DietaryTag, Object> dietqaryTagRepository;
    private final Restaurant restaurant;
    private FoodeeClient client;

    private long limit = 300;

    public GetAllDietaryTags(FoodeeClient client, Restaurant restaurant) {
        this.client = client;
        this.dietqaryTagRepository = client.getRepository(DietaryTag.class);
        this.restaurant = restaurant;
    }

    public ResourceList<DietaryTag> invoke() {
        val querySpec = new QuerySpec(DietaryTag.class);
        querySpec.setPaging(getPagingSpec());
        return this.dietqaryTagRepository.findAll(querySpec);
    }
}
