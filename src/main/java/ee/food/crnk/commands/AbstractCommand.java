package ee.food.crnk.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractCommand {

    protected final Logger logger;

    public AbstractCommand() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }
}
