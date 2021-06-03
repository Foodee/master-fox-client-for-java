package ee.food.crnk.repositories;

import ee.food.crnk.resources.DeskCase;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DeskCaseRepository extends ResourceRepositoryBase<DeskCase, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, DeskCase> records = new ConcurrentHashMap<>();

    public DeskCaseRepository(Class<DeskCase> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends DeskCase> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends DeskCase> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("DeskCase already exists");
      }
        return save(entity);
    }

    @Override
    public Class<DeskCase> getResourceClass() {
        return DeskCase.class;
    }

    @Override
    public ResourceList<DeskCase> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
