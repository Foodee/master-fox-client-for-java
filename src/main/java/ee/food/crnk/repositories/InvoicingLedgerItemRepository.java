package ee.food.crnk.repositories;

import ee.food.crnk.resources.InvoicingLedgerItem;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InvoicingLedgerItemRepository extends ResourceRepositoryBase<InvoicingLedgerItem, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, InvoicingLedgerItem> records = new ConcurrentHashMap<>();

    public InvoicingLedgerItemRepository(Class<InvoicingLedgerItem> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends InvoicingLedgerItem> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends InvoicingLedgerItem> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("InvoicingLedgerItem already exists");
      }
        return save(entity);
    }

    @Override
    public Class<InvoicingLedgerItem> getResourceClass() {
        return InvoicingLedgerItem.class;
    }

    @Override
    public ResourceList<InvoicingLedgerItem> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
