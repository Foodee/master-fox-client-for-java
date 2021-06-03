package ee.food.crnk.repositories;

import ee.food.crnk.resources.RestaurantClosure;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RestaurantClosureRepository extends ResourceRepositoryBase<RestaurantClosure, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, RestaurantClosure> records = new ConcurrentHashMap<>();

    public RestaurantClosureRepository(Class<RestaurantClosure> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends RestaurantClosure> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends RestaurantClosure> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("RestaurantClosure already exists");
      }
        return save(entity);
    }

    @Override
    public Class<RestaurantClosure> getResourceClass() {
        return RestaurantClosure.class;
    }

    @Override
    public ResourceList<RestaurantClosure> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
