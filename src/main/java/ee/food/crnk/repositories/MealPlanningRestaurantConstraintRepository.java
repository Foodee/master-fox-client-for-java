package ee.food.crnk.repositories;

import ee.food.crnk.resources.MealPlanningRestaurantConstraint;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealPlanningRestaurantConstraintRepository extends ResourceRepositoryBase<MealPlanningRestaurantConstraint, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MealPlanningRestaurantConstraint> records = new ConcurrentHashMap<>();

    public MealPlanningRestaurantConstraintRepository(Class<MealPlanningRestaurantConstraint> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MealPlanningRestaurantConstraint> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MealPlanningRestaurantConstraint> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MealPlanningRestaurantConstraint already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MealPlanningRestaurantConstraint> getResourceClass() {
        return MealPlanningRestaurantConstraint.class;
    }

    @Override
    public ResourceList<MealPlanningRestaurantConstraint> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
