package ee.food.crnk.repositories;

import ee.food.crnk.resources.AccountingLedgerItem;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class AccountingLedgerItemRepository extends ResourceRepositoryBase<AccountingLedgerItem, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, AccountingLedgerItem> records = new ConcurrentHashMap<>();

    public AccountingLedgerItemRepository(Class<AccountingLedgerItem> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends AccountingLedgerItem> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends AccountingLedgerItem> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("AccountingLedgerItem already exists");
      }
        return save(entity);
    }

    @Override
    public Class<AccountingLedgerItem> getResourceClass() {
        return AccountingLedgerItem.class;
    }

    @Override
    public ResourceList<AccountingLedgerItem> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
