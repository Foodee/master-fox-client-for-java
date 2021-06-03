package ee.food.crnk.repositories;

import ee.food.crnk.resources.EmailMessage;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.exception.BadRequestException;
import io.crnk.core.resource.list.ResourceList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class EmailMessageRepository extends ResourceRepositoryBase<EmailMessage, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(124000000);
    private static final Map<Long, EmailMessage> records = new ConcurrentHashMap<>();

    public EmailMessageRepository(Class<EmailMessage> resourceClass) {
        super(resourceClass);
    }

    @Override
    public <S extends EmailMessage> S save(S entity) {
      if (entity.getId() == null) {
        entity.setId(ID_GENERATOR.getAndIncrement());
      }
      records.put(entity.getId(), entity);
      return entity;
    }

    @Override
    public <S extends EmailMessage> S create(S entity) {
      if (entity.getId() != null && records.containsKey(entity.getId())) {
        throw new BadRequestException("EmailMessage already exists");
      }
        return save(entity);
    }

    @Override
    public Class<EmailMessage> getResourceClass() {
        return EmailMessage.class;
    }

    @Override
    public ResourceList<EmailMessage> findAll(QuerySpec querySpec) {
        return querySpec.apply(records.values());
    }
}
