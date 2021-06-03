package ee.food.crnk.repositories;

import ee.food.crnk.resources.Team;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class TeamRepository extends ResourceRepositoryBase<Team, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, Team> records = new ConcurrentHashMap<>();

    public TeamRepository(Class<Team> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends Team> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends Team> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("Team already exists");
      }
        return save(entity);
    }

    @Override
    public Class<Team> getResourceClass() {
        return Team.class;
    }

    @Override
    public ResourceList<Team> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
