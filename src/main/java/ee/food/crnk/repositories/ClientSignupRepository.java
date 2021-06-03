package ee.food.crnk.repositories;

import ee.food.crnk.resources.ClientSignup;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ClientSignupRepository extends ResourceRepositoryBase<ClientSignup, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, ClientSignup> records = new ConcurrentHashMap<>();

    public ClientSignupRepository(Class<ClientSignup> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends ClientSignup> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends ClientSignup> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("ClientSignup already exists");
      }
        return save(entity);
    }

    @Override
    public Class<ClientSignup> getResourceClass() {
        return ClientSignup.class;
    }

    @Override
    public ResourceList<ClientSignup> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
