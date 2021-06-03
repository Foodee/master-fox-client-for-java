package ee.food.crnk.repositories;

import ee.food.crnk.resources.AppConfiguration;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class AppConfigurationRepository extends ResourceRepositoryBase<AppConfiguration, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, AppConfiguration> records = new ConcurrentHashMap<>();

    public AppConfigurationRepository(Class<AppConfiguration> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends AppConfiguration> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends AppConfiguration> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("AppConfiguration already exists");
      }
        return save(entity);
    }

    @Override
    public Class<AppConfiguration> getResourceClass() {
        return AppConfiguration.class;
    }

    @Override
    public ResourceList<AppConfiguration> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
