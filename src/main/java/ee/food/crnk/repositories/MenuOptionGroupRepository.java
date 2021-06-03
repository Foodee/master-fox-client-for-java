package ee.food.crnk.repositories;

import ee.food.crnk.resources.MenuOptionGroup;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MenuOptionGroupRepository extends ResourceRepositoryBase<MenuOptionGroup, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MenuOptionGroup> records = new ConcurrentHashMap<>();

    public MenuOptionGroupRepository(Class<MenuOptionGroup> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MenuOptionGroup> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MenuOptionGroup> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MenuOptionGroup already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MenuOptionGroup> getResourceClass() {
        return MenuOptionGroup.class;
    }

    @Override
    public ResourceList<MenuOptionGroup> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
