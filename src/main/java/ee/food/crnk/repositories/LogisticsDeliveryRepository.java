package ee.food.crnk.repositories;

import ee.food.crnk.resources.LogisticsDelivery;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class LogisticsDeliveryRepository extends ResourceRepositoryBase<LogisticsDelivery, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, LogisticsDelivery> records = new ConcurrentHashMap<>();

    public LogisticsDeliveryRepository(Class<LogisticsDelivery> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends LogisticsDelivery> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends LogisticsDelivery> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("LogisticsDelivery already exists");
      }
        return save(entity);
    }

    @Override
    public Class<LogisticsDelivery> getResourceClass() {
        return LogisticsDelivery.class;
    }

    @Override
    public ResourceList<LogisticsDelivery> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
