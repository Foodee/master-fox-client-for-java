package ee.food.crnk.repositories;

import ee.food.crnk.resources.FeatureFlagDescription;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class FeatureFlagDescriptionRepository extends ResourceRepositoryBase<FeatureFlagDescription, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, FeatureFlagDescription> records = new ConcurrentHashMap<>();

    public FeatureFlagDescriptionRepository(Class<FeatureFlagDescription> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends FeatureFlagDescription> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends FeatureFlagDescription> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("FeatureFlagDescription already exists");
      }
        return save(entity);
    }

    @Override
    public Class<FeatureFlagDescription> getResourceClass() {
        return FeatureFlagDescription.class;
    }

    @Override
    public ResourceList<FeatureFlagDescription> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
