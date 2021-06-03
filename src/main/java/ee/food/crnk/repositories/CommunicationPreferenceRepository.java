package ee.food.crnk.repositories;

import ee.food.crnk.resources.CommunicationPreference;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CommunicationPreferenceRepository extends ResourceRepositoryBase<CommunicationPreference, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, CommunicationPreference> records = new ConcurrentHashMap<>();

    public CommunicationPreferenceRepository(Class<CommunicationPreference> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends CommunicationPreference> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends CommunicationPreference> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("CommunicationPreference already exists");
      }
        return save(entity);
    }

    @Override
    public Class<CommunicationPreference> getResourceClass() {
        return CommunicationPreference.class;
    }

    @Override
    public ResourceList<CommunicationPreference> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
