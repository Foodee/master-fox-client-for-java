package ee.food.crnk.repositories;

import ee.food.crnk.resources.DeliveryLocation;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DeliveryLocationRepository extends ResourceRepositoryBase<DeliveryLocation, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, DeliveryLocation> records = new ConcurrentHashMap<>();

    public DeliveryLocationRepository(Class<DeliveryLocation> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends DeliveryLocation> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends DeliveryLocation> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("DeliveryLocation already exists");
      }
        return save(entity);
    }

    @Override
    public Class<DeliveryLocation> getResourceClass() {
        return DeliveryLocation.class;
    }

    @Override
    public ResourceList<DeliveryLocation> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
