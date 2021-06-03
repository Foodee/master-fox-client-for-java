package ee.food.crnk.repositories;

import ee.food.crnk.resources.OrderItem;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class OrderItemRepository extends ResourceRepositoryBase<OrderItem, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, OrderItem> records = new ConcurrentHashMap<>();

    public OrderItemRepository(Class<OrderItem> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends OrderItem> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends OrderItem> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("OrderItem already exists");
      }
        return save(entity);
    }

    @Override
    public Class<OrderItem> getResourceClass() {
        return OrderItem.class;
    }

    @Override
    public ResourceList<OrderItem> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
