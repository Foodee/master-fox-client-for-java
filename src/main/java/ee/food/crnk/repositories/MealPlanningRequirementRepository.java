package ee.food.crnk.repositories;

import ee.food.crnk.resources.MealPlanningRequirement;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealPlanningRequirementRepository extends ResourceRepositoryBase<MealPlanningRequirement, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MealPlanningRequirement> records = new ConcurrentHashMap<>();

    public MealPlanningRequirementRepository(Class<MealPlanningRequirement> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MealPlanningRequirement> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MealPlanningRequirement> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MealPlanningRequirement already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MealPlanningRequirement> getResourceClass() {
        return MealPlanningRequirement.class;
    }

    @Override
    public ResourceList<MealPlanningRequirement> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
