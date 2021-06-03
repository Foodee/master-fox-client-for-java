package ee.food.crnk.repositories;

import ee.food.crnk.resources.Invoice;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InvoiceRepository extends ResourceRepositoryBase<Invoice, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, Invoice> records = new ConcurrentHashMap<>();

    public InvoiceRepository(Class<Invoice> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends Invoice> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends Invoice> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("Invoice already exists");
      }
        return save(entity);
    }

    @Override
    public Class<Invoice> getResourceClass() {
        return Invoice.class;
    }

    @Override
    public ResourceList<Invoice> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
