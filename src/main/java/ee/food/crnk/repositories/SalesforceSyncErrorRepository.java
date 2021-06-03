package ee.food.crnk.repositories;

import ee.food.crnk.resources.SalesforceSyncError;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class SalesforceSyncErrorRepository extends ResourceRepositoryBase<SalesforceSyncError, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, SalesforceSyncError> records = new ConcurrentHashMap<>();

    public SalesforceSyncErrorRepository(Class<SalesforceSyncError> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends SalesforceSyncError> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends SalesforceSyncError> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("SalesforceSyncError already exists");
      }
        return save(entity);
    }

    @Override
    public Class<SalesforceSyncError> getResourceClass() {
        return SalesforceSyncError.class;
    }

    @Override
    public ResourceList<SalesforceSyncError> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
