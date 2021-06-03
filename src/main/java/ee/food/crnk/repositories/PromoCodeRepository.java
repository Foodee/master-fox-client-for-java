package ee.food.crnk.repositories;

import ee.food.crnk.resources.PromoCode;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PromoCodeRepository extends ResourceRepositoryBase<PromoCode, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, PromoCode> records = new ConcurrentHashMap<>();

    public PromoCodeRepository(Class<PromoCode> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends PromoCode> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends PromoCode> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("PromoCode already exists");
      }
        return save(entity);
    }

    @Override
    public Class<PromoCode> getResourceClass() {
        return PromoCode.class;
    }

    @Override
    public ResourceList<PromoCode> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
