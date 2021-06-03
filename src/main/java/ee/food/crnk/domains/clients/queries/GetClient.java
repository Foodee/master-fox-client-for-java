package ee.food.crnk.domains.clients.queries;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.queries.AbstractQuery;
import ee.food.crnk.resources.Client;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepository;
import lombok.val;

import java.util.Arrays;

public class GetClient extends AbstractQuery {

    private Long clientId;
    private final ResourceRepository<Client, Object> clientRepository;
    private FoodeeClient client;

    public GetClient(FoodeeClient client, Long clientId) {
        this.client = client;
        this.clientRepository = client.getRepository(Client.class);
        this.clientId = clientId;
    }

    public Client invoke() {
        logger.info(String.format("Looking up client#%d", this.clientId));
        val querySpec = new QuerySpec(Client.class);
        querySpec.includeRelation(Arrays.asList("deliveryLocations", "location"));
        querySpec.includeRelation(Arrays.asList("owner"));

        return this.clientRepository.findOne(clientId, querySpec);
    }
}
