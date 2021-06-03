package ee.food.crnk.repositories;

import ee.food.crnk.resources.CurrenciesTransaction;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CurrenciesTransactionRepository extends ResourceRepositoryBase<CurrenciesTransaction, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, CurrenciesTransaction> records = new ConcurrentHashMap<>();

    public CurrenciesTransactionRepository(Class<CurrenciesTransaction> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends CurrenciesTransaction> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends CurrenciesTransaction> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("CurrenciesTransaction already exists");
      }
        return save(entity);
    }

    @Override
    public Class<CurrenciesTransaction> getResourceClass() {
        return CurrenciesTransaction.class;
    }

    @Override
    public ResourceList<CurrenciesTransaction> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
