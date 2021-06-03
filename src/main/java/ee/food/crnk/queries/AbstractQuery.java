package ee.food.crnk.queries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractQuery {

    protected final Logger logger;

    public AbstractQuery() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

}
