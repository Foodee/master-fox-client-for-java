package ee.food.crnk.repositories;

import ee.food.crnk.resources.CurrenciesCurrency;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CurrenciesCurrencyRepository extends ResourceRepositoryBase<CurrenciesCurrency, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, CurrenciesCurrency> records = new ConcurrentHashMap<>();

    public CurrenciesCurrencyRepository(Class<CurrenciesCurrency> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends CurrenciesCurrency> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends CurrenciesCurrency> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("CurrenciesCurrency already exists");
      }
        return save(entity);
    }

    @Override
    public Class<CurrenciesCurrency> getResourceClass() {
        return CurrenciesCurrency.class;
    }

    @Override
    public ResourceList<CurrenciesCurrency> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
