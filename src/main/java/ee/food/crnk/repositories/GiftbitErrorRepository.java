package ee.food.crnk.repositories;

import ee.food.crnk.resources.GiftbitError;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class GiftbitErrorRepository extends ResourceRepositoryBase<GiftbitError, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, GiftbitError> records = new ConcurrentHashMap<>();

    public GiftbitErrorRepository(Class<GiftbitError> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends GiftbitError> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends GiftbitError> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("GiftbitError already exists");
      }
        return save(entity);
    }

    @Override
    public Class<GiftbitError> getResourceClass() {
        return GiftbitError.class;
    }

    @Override
    public ResourceList<GiftbitError> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
