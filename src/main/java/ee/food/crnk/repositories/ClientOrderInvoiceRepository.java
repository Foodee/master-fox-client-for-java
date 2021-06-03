package ee.food.crnk.repositories;

import ee.food.crnk.resources.ClientOrderInvoice;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ClientOrderInvoiceRepository extends ResourceRepositoryBase<ClientOrderInvoice, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, ClientOrderInvoice> records = new ConcurrentHashMap<>();

    public ClientOrderInvoiceRepository(Class<ClientOrderInvoice> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends ClientOrderInvoice> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends ClientOrderInvoice> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("ClientOrderInvoice already exists");
      }
        return save(entity);
    }

    @Override
    public Class<ClientOrderInvoice> getResourceClass() {
        return ClientOrderInvoice.class;
    }

    @Override
    public ResourceList<ClientOrderInvoice> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
