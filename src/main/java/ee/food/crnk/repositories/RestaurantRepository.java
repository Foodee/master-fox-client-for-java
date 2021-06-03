package ee.food.crnk.repositories;

import ee.food.crnk.resources.Restaurant;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RestaurantRepository extends ResourceRepositoryBase<Restaurant, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, Restaurant> records = new ConcurrentHashMap<>();

    public RestaurantRepository(Class<Restaurant> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends Restaurant> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends Restaurant> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("Restaurant already exists");
      }
        return save(entity);
    }

    @Override
    public Class<Restaurant> getResourceClass() {
        return Restaurant.class;
    }

    @Override
    public ResourceList<Restaurant> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
