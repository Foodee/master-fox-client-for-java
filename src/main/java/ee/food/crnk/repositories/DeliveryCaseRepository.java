package ee.food.crnk.repositories;

import ee.food.crnk.resources.DeliveryCase;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DeliveryCaseRepository extends ResourceRepositoryBase<DeliveryCase, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, DeliveryCase> records = new ConcurrentHashMap<>();

    public DeliveryCaseRepository(Class<DeliveryCase> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends DeliveryCase> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends DeliveryCase> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("DeliveryCase already exists");
      }
        return save(entity);
    }

    @Override
    public Class<DeliveryCase> getResourceClass() {
        return DeliveryCase.class;
    }

    @Override
    public ResourceList<DeliveryCase> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
