package ee.food.crnk.repositories;

import ee.food.crnk.resources.Area;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class AreaRepository extends ResourceRepositoryBase<Area, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, Area> records = new ConcurrentHashMap<>();

    public AreaRepository(Class<Area> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends Area> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends Area> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("Area already exists");
      }
        return save(entity);
    }

    @Override
    public Class<Area> getResourceClass() {
        return Area.class;
    }

    @Override
    public ResourceList<Area> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
