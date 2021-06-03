package ee.food.crnk.repositories;

import ee.food.crnk.resources.MenuOptionItem;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MenuOptionItemRepository extends ResourceRepositoryBase<MenuOptionItem, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, MenuOptionItem> records = new ConcurrentHashMap<>();

    public MenuOptionItemRepository(Class<MenuOptionItem> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends MenuOptionItem> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends MenuOptionItem> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("MenuOptionItem already exists");
      }
        return save(entity);
    }

    @Override
    public Class<MenuOptionItem> getResourceClass() {
        return MenuOptionItem.class;
    }

    @Override
    public ResourceList<MenuOptionItem> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
