package ee.food.crnk.repositories;

import ee.food.crnk.resources.DiscountCode;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DiscountCodeRepository extends ResourceRepositoryBase<DiscountCode, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, DiscountCode> records = new ConcurrentHashMap<>();

    public DiscountCodeRepository(Class<DiscountCode> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends DiscountCode> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends DiscountCode> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("DiscountCode already exists");
      }
        return save(entity);
    }

    @Override
    public Class<DiscountCode> getResourceClass() {
        return DiscountCode.class;
    }

    @Override
    public ResourceList<DiscountCode> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
