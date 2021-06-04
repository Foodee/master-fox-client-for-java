package ee.food.crnk.domains.ordering.commands;

import ee.food.crnk.FoodeeClient;
import ee.food.crnk.commands.AbstractCommand;
import ee.food.crnk.domains.clients.queries.GetClient;
import ee.food.crnk.domains.ordering.queries.GetOrder;
import ee.food.crnk.domains.restaurants.queries.GetRestaurant;
import ee.food.crnk.resources.Area;
import ee.food.crnk.resources.GroupOrderMember;
import ee.food.crnk.resources.Order;
import ee.food.crnk.resources.User;
import io.crnk.core.repository.ResourceRepository;
import lombok.Data;
import lombok.val;
import lombok.var;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class CreateGroupOrderMember extends AbstractCommand<GroupOrderMember> {

    private FoodeeClient foodeeClient;
    private final Long orderId;
    private final String fullName;
    private final String email;
    private final Optional<Long> userId;
    private ResourceRepository<GroupOrderMember, Object> groupOrderMemberRepository;

    public CreateGroupOrderMember(FoodeeClient foodeeClient, Long orderId, String fullName, String email, Optional<Long> userId) {
        this.foodeeClient = foodeeClient;
        this.orderId = orderId;
        this.fullName = fullName;
        this.email = email;
        this.userId = userId;
        this.init();
    }

    public CreateGroupOrderMember(FoodeeClient foodeeClient, Long orderId, String fullName, String email) {
        this(foodeeClient, orderId, fullName, email, Optional.empty());
    }

    private void init() {
        this.groupOrderMemberRepository = foodeeClient.getRepository(GroupOrderMember.class);
    }


    public GroupOrderMember invoke() {
        val gom = new GroupOrderMember();
        gom.setOrder(Order.id(this.orderId));
        gom.setName(this.fullName);
        gom.setEmail(this.email);

        this.userId.ifPresent(aLong -> gom.setUser(User.id(aLong)));

        logger.info("Creating GroupOrderMember with the following params");
        logger.info(gom.toString());

        return this.groupOrderMemberRepository.create(gom);
    }

}
