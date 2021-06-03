package ee.food.crnk.repositories;

import ee.food.crnk.resources.DietaryTag;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DietaryTagRepository extends ResourceRepositoryBase<DietaryTag, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, DietaryTag> records = new ConcurrentHashMap<>();

    public DietaryTagRepository(Class<DietaryTag> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends DietaryTag> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends DietaryTag> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("DietaryTag already exists");
      }
        return save(entity);
    }

    @Override
    public Class<DietaryTag> getResourceClass() {
        return DietaryTag.class;
    }

    @Override
    public ResourceList<DietaryTag> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
