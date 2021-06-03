package ee.food.crnk.repositories;

import ee.food.crnk.resources.MealPlanningTemplate;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealPlanningTemplateRepository extends ResourceRepositoryBase<MealPlanningTemplate, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MealPlanningTemplate> records = new ConcurrentHashMap<>();

    public MealPlanningTemplateRepository(Class<MealPlanningTemplate> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MealPlanningTemplate> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MealPlanningTemplate> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MealPlanningTemplate already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MealPlanningTemplate> getResourceClass() {
        return MealPlanningTemplate.class;
    }

    @Override
    public ResourceList<MealPlanningTemplate> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
