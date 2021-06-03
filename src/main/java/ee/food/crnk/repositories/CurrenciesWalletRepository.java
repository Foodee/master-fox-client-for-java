package ee.food.crnk.repositories;

import ee.food.crnk.resources.CurrenciesWallet;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CurrenciesWalletRepository extends ResourceRepositoryBase<CurrenciesWallet, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, CurrenciesWallet> records = new ConcurrentHashMap<>();

    public CurrenciesWalletRepository(Class<CurrenciesWallet> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends CurrenciesWallet> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends CurrenciesWallet> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("CurrenciesWallet already exists");
      }
        return save(entity);
    }

    @Override
    public Class<CurrenciesWallet> getResourceClass() {
        return CurrenciesWallet.class;
    }

    @Override
    public ResourceList<CurrenciesWallet> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
