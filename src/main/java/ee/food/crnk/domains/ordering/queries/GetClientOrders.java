package ee.food.crnk.domains.ordering.queries;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.domains.ordering.OrderState;
import ee.food.crnk.queries.AbstractQuery;
import ee.food.crnk.resources.Client;
import ee.food.crnk.resources.Order;
import ee.food.crnk.resources.User;
import io.crnk.core.queryspec.FilterOperator;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ManyRelationshipRepository;
import io.crnk.core.resource.list.ResourceList;

import java.util.*;

import static java.util.Collections.*;

public class GetClientOrders extends AbstractQuery {


    private final FoodeeClient client;
    private final Long clientId;
    private final Optional<Date> deliverOn;
    private ManyRelationshipRepository<Client, Object, Order, Object> repository;
    private Optional<List<OrderState>> states;

    public GetClientOrders(FoodeeClient client, Long clientId, Optional<Date> deliverOn, Optional<List<OrderState>> states) {
        this.client = client;
        this.clientId = clientId;
        this.deliverOn = deliverOn;
        this.repository = client.getManyRepository(Client.class, Order.class);
        this.states = states;
    }

    public GetClientOrders(FoodeeClient client, Long clientId) {
        this(client, clientId, Optional.empty(), Optional.empty());
    }

    public GetClientOrders(FoodeeClient client, Long clientId, OrderState... states) {
        this(client, clientId, Optional.empty(), Optional.of(Arrays.asList(states)));
    }

    public ResourceList<Order> invoke() {
        logger.info(String.format("Looking up orders for client#%d", this.clientId));

        QuerySpec querySpec = new QuerySpec(Order.class);

        this.states.ifPresent(orderStates -> querySpec.addFilter(PathSpec.of("state").filter(FilterOperator.EQ, orderStates)));

        this.deliverOn.ifPresent(date -> querySpec.addFilter(PathSpec.of("deliverOn").filter(FilterOperator.EQ, singletonList(date))));

        querySpec.includeRelation(singletonList("restaurant"));
        querySpec.includeRelation(singletonList("menu"));

        querySpec.setPaging(getPagingSpec());

        return this.repository.findManyRelations(singletonList(this.clientId), "orders", querySpec).get(this.clientId);
    }

}
