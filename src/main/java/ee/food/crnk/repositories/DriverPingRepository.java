package ee.food.crnk.repositories;

import ee.food.crnk.resources.DriverPing;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DriverPingRepository extends ResourceRepositoryBase<DriverPing, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, DriverPing> records = new ConcurrentHashMap<>();

    public DriverPingRepository(Class<DriverPing> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends DriverPing> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends DriverPing> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("DriverPing already exists");
      }
        return save(entity);
    }

    @Override
    public Class<DriverPing> getResourceClass() {
        return DriverPing.class;
    }

    @Override
    public ResourceList<DriverPing> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
