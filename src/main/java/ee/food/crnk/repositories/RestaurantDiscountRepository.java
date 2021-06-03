package ee.food.crnk.repositories;

import ee.food.crnk.resources.RestaurantDiscount;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RestaurantDiscountRepository extends ResourceRepositoryBase<RestaurantDiscount, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, RestaurantDiscount> records = new ConcurrentHashMap<>();

    public RestaurantDiscountRepository(Class<RestaurantDiscount> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends RestaurantDiscount> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends RestaurantDiscount> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("RestaurantDiscount already exists");
      }
        return save(entity);
    }

    @Override
    public Class<RestaurantDiscount> getResourceClass() {
        return RestaurantDiscount.class;
    }

    @Override
    public ResourceList<RestaurantDiscount> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
