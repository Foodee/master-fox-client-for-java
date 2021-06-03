package ee.food.crnk.repositories;

import ee.food.crnk.resources.MealPlanningRequirementConstraint;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealPlanningRequirementConstraintRepository extends ResourceRepositoryBase<MealPlanningRequirementConstraint, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MealPlanningRequirementConstraint> records = new ConcurrentHashMap<>();

    public MealPlanningRequirementConstraintRepository(Class<MealPlanningRequirementConstraint> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MealPlanningRequirementConstraint> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MealPlanningRequirementConstraint> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MealPlanningRequirementConstraint already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MealPlanningRequirementConstraint> getResourceClass() {
        return MealPlanningRequirementConstraint.class;
    }

    @Override
    public ResourceList<MealPlanningRequirementConstraint> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
