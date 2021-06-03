package ee.food.crnk.repositories;

import ee.food.crnk.resources.PaymentCard;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentCardRepository extends ResourceRepositoryBase<PaymentCard, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, PaymentCard> records = new ConcurrentHashMap<>();

    public PaymentCardRepository(Class<PaymentCard> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends PaymentCard> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends PaymentCard> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("PaymentCard already exists");
      }
        return save(entity);
    }

    @Override
    public Class<PaymentCard> getResourceClass() {
        return PaymentCard.class;
    }

    @Override
    public ResourceList<PaymentCard> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
