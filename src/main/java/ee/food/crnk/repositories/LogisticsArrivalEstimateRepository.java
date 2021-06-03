package ee.food.crnk.repositories;

import ee.food.crnk.resources.LogisticsArrivalEstimate;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class LogisticsArrivalEstimateRepository extends ResourceRepositoryBase<LogisticsArrivalEstimate, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, LogisticsArrivalEstimate> records = new ConcurrentHashMap<>();

    public LogisticsArrivalEstimateRepository(Class<LogisticsArrivalEstimate> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends LogisticsArrivalEstimate> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends LogisticsArrivalEstimate> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("LogisticsArrivalEstimate already exists");
      }
        return save(entity);
    }

    @Override
    public Class<LogisticsArrivalEstimate> getResourceClass() {
        return LogisticsArrivalEstimate.class;
    }

    @Override
    public ResourceList<LogisticsArrivalEstimate> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
