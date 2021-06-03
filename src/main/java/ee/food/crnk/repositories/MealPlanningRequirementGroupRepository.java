package ee.food.crnk.repositories;

import ee.food.crnk.resources.MealPlanningRequirementGroup;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealPlanningRequirementGroupRepository extends ResourceRepositoryBase<MealPlanningRequirementGroup, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MealPlanningRequirementGroup> records = new ConcurrentHashMap<>();

    public MealPlanningRequirementGroupRepository(Class<MealPlanningRequirementGroup> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MealPlanningRequirementGroup> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MealPlanningRequirementGroup> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MealPlanningRequirementGroup already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MealPlanningRequirementGroup> getResourceClass() {
        return MealPlanningRequirementGroup.class;
    }

    @Override
    public ResourceList<MealPlanningRequirementGroup> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
