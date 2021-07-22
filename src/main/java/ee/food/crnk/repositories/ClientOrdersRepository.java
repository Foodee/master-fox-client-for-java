package ee.food.crnk.repositories;

import ee.food.crnk.resources.Client;
import ee.food.crnk.resources.Order;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ManyRelationshipRepositoryBase;
import io.crnk.core.repository.RelationshipMatcher;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientOrdersRepository extends ManyRelationshipRepositoryBase<Client, Long, Order, Long> {
    @Override
    public RelationshipMatcher getMatcher() {
        return new RelationshipMatcher().rule().target(Order.class).add();
    }

    @Override
    public Map<Long, ResourceList<Order>> findManyRelations(Collection<Long> sourceIds, String fieldName, QuerySpec querySpec) {
        Map<Long, ResourceList<Order>> map = new HashMap<>();
        for (Long sourceId : sourceIds) {
            DefaultResourceList list = new DefaultResourceList();
            for (int i = 0; i < 10; i++) {
                Order order = new Order();
                order.setId(sourceId);
                list.add(order);
            }
            map.put(sourceId, list);
        }
        return map;
    }
}
