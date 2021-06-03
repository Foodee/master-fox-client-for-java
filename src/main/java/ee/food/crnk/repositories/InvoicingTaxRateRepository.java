package ee.food.crnk.repositories;

import ee.food.crnk.resources.InvoicingTaxRate;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InvoicingTaxRateRepository extends ResourceRepositoryBase<InvoicingTaxRate, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, InvoicingTaxRate> records = new ConcurrentHashMap<>();

    public InvoicingTaxRateRepository(Class<InvoicingTaxRate> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends InvoicingTaxRate> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends InvoicingTaxRate> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("InvoicingTaxRate already exists");
      }
        return save(entity);
    }

    @Override
    public Class<InvoicingTaxRate> getResourceClass() {
        return InvoicingTaxRate.class;
    }

    @Override
    public ResourceList<InvoicingTaxRate> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
