package ee.food.crnk.repositories;

import ee.food.crnk.resources.MenuItem;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MenuItemRepository extends ResourceRepositoryBase<MenuItem, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MenuItem> records = new ConcurrentHashMap<>();

    public MenuItemRepository(Class<MenuItem> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MenuItem> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MenuItem> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MenuItem already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MenuItem> getResourceClass() {
        return MenuItem.class;
    }

    @Override
    public ResourceList<MenuItem> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
