package ee.food.crnk.repositories;

import ee.food.crnk.resources.ClientDiscount;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ClientDiscountRepository extends ResourceRepositoryBase<ClientDiscount, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, ClientDiscount> records = new ConcurrentHashMap<>();

    public ClientDiscountRepository(Class<ClientDiscount> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends ClientDiscount> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends ClientDiscount> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("ClientDiscount already exists");
      }
        return save(entity);
    }

    @Override
    public Class<ClientDiscount> getResourceClass() {
        return ClientDiscount.class;
    }

    @Override
    public ResourceList<ClientDiscount> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
