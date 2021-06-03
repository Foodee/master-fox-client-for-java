package ee.food.crnk.repositories;

import ee.food.crnk.resources.UserInvite;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserInviteRepository extends ResourceRepositoryBase<UserInvite, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, UserInvite> records = new ConcurrentHashMap<>();

    public UserInviteRepository(Class<UserInvite> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends UserInvite> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends UserInvite> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("UserInvite already exists");
      }
        return save(entity);
    }

    @Override
    public Class<UserInvite> getResourceClass() {
        return UserInvite.class;
    }

    @Override
    public ResourceList<UserInvite> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
