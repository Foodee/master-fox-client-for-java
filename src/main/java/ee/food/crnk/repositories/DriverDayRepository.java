package ee.food.crnk.repositories;

import ee.food.crnk.resources.DriverDay;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DriverDayRepository extends ResourceRepositoryBase<DriverDay, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, DriverDay> records = new ConcurrentHashMap<>();

    public DriverDayRepository(Class<DriverDay> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends DriverDay> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends DriverDay> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("DriverDay already exists");
      }
        return save(entity);
    }

    @Override
    public Class<DriverDay> getResourceClass() {
        return DriverDay.class;
    }

    @Override
    public ResourceList<DriverDay> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
