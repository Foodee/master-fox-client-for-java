package ee.food.crnk.repositories;

import ee.food.crnk.resources.MealType;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealTypeRepository extends ResourceRepositoryBase<MealType, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MealType> records = new ConcurrentHashMap<>();

    public MealTypeRepository(Class<MealType> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MealType> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MealType> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MealType already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MealType> getResourceClass() {
        return MealType.class;
    }

    @Override
    public ResourceList<MealType> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
