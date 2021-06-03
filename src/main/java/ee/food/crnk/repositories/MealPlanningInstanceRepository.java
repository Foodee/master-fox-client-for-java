package ee.food.crnk.repositories;

import ee.food.crnk.resources.MealPlanningInstance;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealPlanningInstanceRepository extends ResourceRepositoryBase<MealPlanningInstance, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MealPlanningInstance> records = new ConcurrentHashMap<>();

    public MealPlanningInstanceRepository(Class<MealPlanningInstance> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MealPlanningInstance> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MealPlanningInstance> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MealPlanningInstance already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MealPlanningInstance> getResourceClass() {
        return MealPlanningInstance.class;
    }

    @Override
    public ResourceList<MealPlanningInstance> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
