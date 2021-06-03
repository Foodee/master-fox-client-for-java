package ee.food.crnk.repositories;

import ee.food.crnk.resources.MealPlanningEvent;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealPlanningEventRepository extends ResourceRepositoryBase<MealPlanningEvent, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MealPlanningEvent> records = new ConcurrentHashMap<>();

    public MealPlanningEventRepository(Class<MealPlanningEvent> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MealPlanningEvent> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MealPlanningEvent> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MealPlanningEvent already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MealPlanningEvent> getResourceClass() {
        return MealPlanningEvent.class;
    }

    @Override
    public ResourceList<MealPlanningEvent> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
