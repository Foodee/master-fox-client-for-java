package ee.food.crnk.repositories;

import ee.food.crnk.resources.SalesforceCase;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class SalesforceCaseRepository extends ResourceRepositoryBase<SalesforceCase, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, SalesforceCase> records = new ConcurrentHashMap<>();

    public SalesforceCaseRepository(Class<SalesforceCase> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends SalesforceCase> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends SalesforceCase> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("SalesforceCase already exists");
      }
        return save(entity);
    }

    @Override
    public Class<SalesforceCase> getResourceClass() {
        return SalesforceCase.class;
    }

    @Override
    public ResourceList<SalesforceCase> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
