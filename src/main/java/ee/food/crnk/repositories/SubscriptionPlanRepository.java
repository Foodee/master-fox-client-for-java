package ee.food.crnk.repositories;

import ee.food.crnk.resources.SubscriptionPlan;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class SubscriptionPlanRepository extends ResourceRepositoryBase<SubscriptionPlan, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, SubscriptionPlan> records = new ConcurrentHashMap<>();

    public SubscriptionPlanRepository(Class<SubscriptionPlan> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends SubscriptionPlan> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends SubscriptionPlan> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("SubscriptionPlan already exists");
      }
        return save(entity);
    }

    @Override
    public Class<SubscriptionPlan> getResourceClass() {
        return SubscriptionPlan.class;
    }

    @Override
    public ResourceList<SubscriptionPlan> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
