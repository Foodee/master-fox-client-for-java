package ee.food.crnk.repositories;

import ee.food.crnk.resources.GiftbitCard;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class GiftbitCardRepository extends ResourceRepositoryBase<GiftbitCard, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, GiftbitCard> records = new ConcurrentHashMap<>();

    public GiftbitCardRepository(Class<GiftbitCard> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends GiftbitCard> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends GiftbitCard> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("GiftbitCard already exists");
      }
        return save(entity);
    }

    @Override
    public Class<GiftbitCard> getResourceClass() {
        return GiftbitCard.class;
    }

    @Override
    public ResourceList<GiftbitCard> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
