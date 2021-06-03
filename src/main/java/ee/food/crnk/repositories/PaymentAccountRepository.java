package ee.food.crnk.repositories;

import ee.food.crnk.resources.PaymentAccount;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentAccountRepository extends ResourceRepositoryBase<PaymentAccount, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, PaymentAccount> records = new ConcurrentHashMap<>();

    public PaymentAccountRepository(Class<PaymentAccount> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends PaymentAccount> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends PaymentAccount> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("PaymentAccount already exists");
      }
        return save(entity);
    }

    @Override
    public Class<PaymentAccount> getResourceClass() {
        return PaymentAccount.class;
    }

    @Override
    public ResourceList<PaymentAccount> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
