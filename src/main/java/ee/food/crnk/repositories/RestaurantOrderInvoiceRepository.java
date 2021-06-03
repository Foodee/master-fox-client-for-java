package ee.food.crnk.repositories;

import ee.food.crnk.resources.RestaurantOrderInvoice;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RestaurantOrderInvoiceRepository extends ResourceRepositoryBase<RestaurantOrderInvoice, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, RestaurantOrderInvoice> records = new ConcurrentHashMap<>();

    public RestaurantOrderInvoiceRepository(Class<RestaurantOrderInvoice> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends RestaurantOrderInvoice> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends RestaurantOrderInvoice> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("RestaurantOrderInvoice already exists");
      }
        return save(entity);
    }

    @Override
    public Class<RestaurantOrderInvoice> getResourceClass() {
        return RestaurantOrderInvoice.class;
    }

    @Override
    public ResourceList<RestaurantOrderInvoice> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
