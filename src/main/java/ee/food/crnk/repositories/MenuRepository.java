package ee.food.crnk.repositories;

import ee.food.crnk.resources.Menu;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MenuRepository extends ResourceRepositoryBase<Menu, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, Menu> records = new ConcurrentHashMap<>();

    public MenuRepository(Class<Menu> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends Menu> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends Menu> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("Menu already exists");
      }
        return save(entity);
    }

    @Override
    public Class<Menu> getResourceClass() {
        return Menu.class;
    }

    @Override
    public ResourceList<Menu> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
