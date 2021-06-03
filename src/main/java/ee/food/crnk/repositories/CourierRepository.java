package ee.food.crnk.repositories;

import ee.food.crnk.resources.Courier;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CourierRepository extends ResourceRepositoryBase<Courier, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, Courier> records = new ConcurrentHashMap<>();

    public CourierRepository(Class<Courier> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends Courier> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends Courier> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("Courier already exists");
      }
        return save(entity);
    }

    @Override
    public Class<Courier> getResourceClass() {
        return Courier.class;
    }

    @Override
    public ResourceList<Courier> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
