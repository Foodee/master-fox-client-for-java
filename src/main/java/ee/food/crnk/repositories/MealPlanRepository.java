package ee.food.crnk.repositories;

import ee.food.crnk.resources.MealPlan;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealPlanRepository extends ResourceRepositoryBase<MealPlan, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MealPlan> records = new ConcurrentHashMap<>();

    public MealPlanRepository(Class<MealPlan> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MealPlan> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MealPlan> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MealPlan already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MealPlan> getResourceClass() {
        return MealPlan.class;
    }

    @Override
    public ResourceList<MealPlan> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
