package ee.food.crnk.repositories;

import ee.food.crnk.resources.Tag;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class TagRepository extends ResourceRepositoryBase<Tag, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, Tag> records = new ConcurrentHashMap<>();

    public TagRepository(Class<Tag> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends Tag> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends Tag> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("Tag already exists");
      }
        return save(entity);
    }

    @Override
    public Class<Tag> getResourceClass() {
        return Tag.class;
    }

    @Override
    public ResourceList<Tag> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
