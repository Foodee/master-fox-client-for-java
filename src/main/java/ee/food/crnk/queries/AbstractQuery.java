package ee.food.crnk.queries;

import io.crnk.core.queryspec.pagingspec.OffsetLimitPagingSpec;
import lombok.Data;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public abstract class AbstractQuery {

    protected final Logger logger;

    private long limit = 20;
    private long page = 0;

    public AbstractQuery() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @NotNull
    protected OffsetLimitPagingSpec getPagingSpec() {
        val pagingSpec = new OffsetLimitPagingSpec();
        pagingSpec.setLimit(limit);
        pagingSpec.setOffset(page);
        return pagingSpec;
    }
}
