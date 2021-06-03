package ee.food.crnk.repositories;

import ee.food.crnk.resources.ServiceTime;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ServiceTimeRepository extends ResourceRepositoryBase<ServiceTime, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, ServiceTime> records = new ConcurrentHashMap<>();

    public ServiceTimeRepository(Class<ServiceTime> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends ServiceTime> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends ServiceTime> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("ServiceTime already exists");
      }
        return save(entity);
    }

    @Override
    public Class<ServiceTime> getResourceClass() {
        return ServiceTime.class;
    }

    @Override
    public ResourceList<ServiceTime> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
