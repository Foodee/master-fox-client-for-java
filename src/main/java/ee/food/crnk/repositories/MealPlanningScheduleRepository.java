package ee.food.crnk.repositories;

import ee.food.crnk.resources.MealPlanningSchedule;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealPlanningScheduleRepository extends ResourceRepositoryBase<MealPlanningSchedule, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MealPlanningSchedule> records = new ConcurrentHashMap<>();

    public MealPlanningScheduleRepository(Class<MealPlanningSchedule> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MealPlanningSchedule> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MealPlanningSchedule> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MealPlanningSchedule already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MealPlanningSchedule> getResourceClass() {
        return MealPlanningSchedule.class;
    }

    @Override
    public ResourceList<MealPlanningSchedule> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
