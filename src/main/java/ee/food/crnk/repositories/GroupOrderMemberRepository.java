package ee.food.crnk.repositories;

import ee.food.crnk.resources.GroupOrderMember;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class GroupOrderMemberRepository extends ResourceRepositoryBase<GroupOrderMember, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, GroupOrderMember> records = new ConcurrentHashMap<>();

    public GroupOrderMemberRepository(Class<GroupOrderMember> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends GroupOrderMember> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends GroupOrderMember> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("GroupOrderMember already exists");
      }
        return save(entity);
    }

    @Override
    public Class<GroupOrderMember> getResourceClass() {
        return GroupOrderMember.class;
    }

    @Override
    public ResourceList<GroupOrderMember> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
