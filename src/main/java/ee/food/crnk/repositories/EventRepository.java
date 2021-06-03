package ee.food.crnk.repositories;

import ee.food.crnk.resources.Event;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class EventRepository extends ResourceRepositoryBase<Event, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, Event> records = new ConcurrentHashMap<>();

    public EventRepository(Class<Event> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends Event> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends Event> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("Event already exists");
      }
        return save(entity);
    }

    @Override
    public Class<Event> getResourceClass() {
        return Event.class;
    }

    @Override
    public ResourceList<Event> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
