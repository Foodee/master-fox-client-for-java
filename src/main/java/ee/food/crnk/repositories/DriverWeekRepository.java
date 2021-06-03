package ee.food.crnk.repositories;

import ee.food.crnk.resources.DriverWeek;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DriverWeekRepository extends ResourceRepositoryBase<DriverWeek, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, DriverWeek> records = new ConcurrentHashMap<>();

    public DriverWeekRepository(Class<DriverWeek> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends DriverWeek> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends DriverWeek> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("DriverWeek already exists");
      }
        return save(entity);
    }

    @Override
    public Class<DriverWeek> getResourceClass() {
        return DriverWeek.class;
    }

    @Override
    public ResourceList<DriverWeek> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
