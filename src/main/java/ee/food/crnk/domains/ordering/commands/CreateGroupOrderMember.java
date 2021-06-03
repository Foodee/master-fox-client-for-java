package ee.food.crnk.domains.ordering.commands;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.commands.AbstractCommand;
import ee.food.crnk.domains.clients.queries.GetClient;
import ee.food.crnk.domains.restaurants.queries.GetRestaurant;
import ee.food.crnk.resources.Area;
import ee.food.crnk.resources.GroupOrderMember;
import ee.food.crnk.resources.Order;
import io.crnk.core.repository.ResourceRepository;
import lombok.Data;
import lombok.val;
import lombok.var;

import java.util.Calendar;
import java.util.Date;

public class CreateGroupOrderMember extends AbstractCommand {

    public GroupOrderMember invoke() {
        return null;
    }

}
