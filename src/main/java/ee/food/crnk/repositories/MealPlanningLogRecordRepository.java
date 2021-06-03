package ee.food.crnk.repositories;

import ee.food.crnk.resources.MealPlanningLogRecord;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MealPlanningLogRecordRepository extends ResourceRepositoryBase<MealPlanningLogRecord, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MealPlanningLogRecord> records = new ConcurrentHashMap<>();

    public MealPlanningLogRecordRepository(Class<MealPlanningLogRecord> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MealPlanningLogRecord> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MealPlanningLogRecord> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MealPlanningLogRecord already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MealPlanningLogRecord> getResourceClass() {
        return MealPlanningLogRecord.class;
    }

    @Override
    public ResourceList<MealPlanningLogRecord> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
