package ee.food.crnk.repositories;

import ee.food.crnk.resources.FoodType;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class FoodTypeRepository extends ResourceRepositoryBase<FoodType, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, FoodType> records = new ConcurrentHashMap<>();

    public FoodTypeRepository(Class<FoodType> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends FoodType> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends FoodType> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("FoodType already exists");
      }
        return save(entity);
    }

    @Override
    public Class<FoodType> getResourceClass() {
        return FoodType.class;
    }

    @Override
    public ResourceList<FoodType> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
