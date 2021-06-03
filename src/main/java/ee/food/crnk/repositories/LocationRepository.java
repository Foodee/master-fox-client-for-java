package ee.food.crnk.repositories;

import ee.food.crnk.resources.Location;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class LocationRepository extends ResourceRepositoryBase<Location, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, Location> records = new ConcurrentHashMap<>();

    public LocationRepository(Class<Location> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends Location> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends Location> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("Location already exists");
      }
        return save(entity);
    }

    @Override
    public Class<Location> getResourceClass() {
        return Location.class;
    }

    @Override
    public ResourceList<Location> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
