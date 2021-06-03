package ee.food.crnk.repositories;

import ee.food.crnk.resources.PickupLocation;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PickupLocationRepository extends ResourceRepositoryBase<PickupLocation, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, PickupLocation> records = new ConcurrentHashMap<>();

    public PickupLocationRepository(Class<PickupLocation> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends PickupLocation> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends PickupLocation> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("PickupLocation already exists");
      }
        return save(entity);
    }

    @Override
    public Class<PickupLocation> getResourceClass() {
        return PickupLocation.class;
    }

    @Override
    public ResourceList<PickupLocation> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
