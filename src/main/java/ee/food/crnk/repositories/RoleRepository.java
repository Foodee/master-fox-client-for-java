package ee.food.crnk.repositories;

import ee.food.crnk.resources.Role;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RoleRepository extends ResourceRepositoryBase<Role, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, Role> records = new ConcurrentHashMap<>();

    public RoleRepository(Class<Role> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends Role> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends Role> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("Role already exists");
      }
        return save(entity);
    }

    @Override
    public Class<Role> getResourceClass() {
        return Role.class;
    }

    @Override
    public ResourceList<Role> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
