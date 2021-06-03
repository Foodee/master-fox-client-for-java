package ee.food.crnk.repositories;

import ee.food.crnk.resources.GiftbitGift;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class GiftbitGiftRepository extends ResourceRepositoryBase<GiftbitGift, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, GiftbitGift> records = new ConcurrentHashMap<>();

    public GiftbitGiftRepository(Class<GiftbitGift> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends GiftbitGift> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends GiftbitGift> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("GiftbitGift already exists");
      }
        return save(entity);
    }

    @Override
    public Class<GiftbitGift> getResourceClass() {
        return GiftbitGift.class;
    }

    @Override
    public ResourceList<GiftbitGift> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
