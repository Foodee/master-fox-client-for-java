package ee.food.crnk.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractCommand<T> {

    protected final Logger logger;

    public AbstractCommand() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    public abstract T invoke();
}
