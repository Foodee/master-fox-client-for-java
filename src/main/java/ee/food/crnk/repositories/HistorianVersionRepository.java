package ee.food.crnk.repositories;

import ee.food.crnk.resources.HistorianVersion;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class HistorianVersionRepository extends ResourceRepositoryBase<HistorianVersion, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, HistorianVersion> records = new ConcurrentHashMap<>();

    public HistorianVersionRepository(Class<HistorianVersion> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends HistorianVersion> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends HistorianVersion> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("HistorianVersion already exists");
      }
        return save(entity);
    }

    @Override
    public Class<HistorianVersion> getResourceClass() {
        return HistorianVersion.class;
    }

    @Override
    public ResourceList<HistorianVersion> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
