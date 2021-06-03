package ee.food.crnk.repositories;

import ee.food.crnk.resources.MealPlanningReservation;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealPlanningReservationRepository extends ResourceRepositoryBase<MealPlanningReservation, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MealPlanningReservation> records = new ConcurrentHashMap<>();

    public MealPlanningReservationRepository(Class<MealPlanningReservation> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MealPlanningReservation> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MealPlanningReservation> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MealPlanningReservation already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MealPlanningReservation> getResourceClass() {
        return MealPlanningReservation.class;
    }

    @Override
    public ResourceList<MealPlanningReservation> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
