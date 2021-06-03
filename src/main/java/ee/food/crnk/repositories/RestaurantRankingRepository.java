package ee.food.crnk.repositories;

import ee.food.crnk.resources.RestaurantRanking;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RestaurantRankingRepository extends ResourceRepositoryBase<RestaurantRanking, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, RestaurantRanking> records = new ConcurrentHashMap<>();

    public RestaurantRankingRepository(Class<RestaurantRanking> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends RestaurantRanking> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends RestaurantRanking> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("RestaurantRanking already exists");
      }
        return save(entity);
    }

    @Override
    public Class<RestaurantRanking> getResourceClass() {
        return RestaurantRanking.class;
    }

    @Override
    public ResourceList<RestaurantRanking> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
