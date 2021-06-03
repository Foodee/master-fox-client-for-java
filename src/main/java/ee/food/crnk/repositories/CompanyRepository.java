package ee.food.crnk.repositories;

import ee.food.crnk.resources.Company;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CompanyRepository extends ResourceRepositoryBase<Company, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, Company> records = new ConcurrentHashMap<>();

    public CompanyRepository(Class<Company> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends Company> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends Company> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("Company already exists");
      }
        return save(entity);
    }

    @Override
    public Class<Company> getResourceClass() {
        return Company.class;
    }

    @Override
    public ResourceList<Company> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
