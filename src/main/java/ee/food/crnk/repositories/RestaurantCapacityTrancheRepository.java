package ee.food.crnk.repositories;

import ee.food.crnk.resources.RestaurantCapacityTranche;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RestaurantCapacityTrancheRepository extends ResourceRepositoryBase<RestaurantCapacityTranche, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, RestaurantCapacityTranche> records = new ConcurrentHashMap<>();

    public RestaurantCapacityTrancheRepository(Class<RestaurantCapacityTranche> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends RestaurantCapacityTranche> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends RestaurantCapacityTranche> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("RestaurantCapacityTranche already exists");
      }
        return save(entity);
    }

    @Override
    public Class<RestaurantCapacityTranche> getResourceClass() {
        return RestaurantCapacityTranche.class;
    }

    @Override
    public ResourceList<RestaurantCapacityTranche> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
