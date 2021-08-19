package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;
import org.javamoney.moneta.Money;

@JsonApiResource(type = "meal-planning-events")
@Data
public class MealPlanningEvent {

    public static MealPlanningEvent id(Long id) {
        val r = new MealPlanningEvent();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "name")
    private String name;

    
    @JsonProperty(value = "lead-time")
    private Float leadTime;

    
    @JsonProperty(value = "number-of-people")
    private Integer numberOfPeople;

    
    @JsonProperty(value = "deliver-at")
    private Date deliverAt;

    
    @JsonProperty(value = "pickup-at")
    private Date pickupAt;

    
    @JsonProperty(value = "meal-id")
    private UUID mealId;

    
    @JsonProperty(value = "user-order-map")
    private Object userOrderMap;

    
    @JsonProperty(value = "created-from-template")
    private Boolean createdFromTemplate;

    
    @JsonProperty(value = "usage-report")
    private Object usageReport;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "instance")
    private MealPlanningInstance instance;

    @JsonApiRelation
    @JsonProperty(value = "orders")
    private List<Order> orders;

    @JsonApiRelation
    @JsonProperty(value = "restaurants")
    private List<Restaurant> restaurants;

    @JsonApiRelation
    @JsonProperty(value = "reservations")
    private List<MealPlanningReservation> reservations;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-constraints")
    private List<MealPlanningRestaurantConstraint> restaurantConstraints;

    @JsonApiRelation
    @JsonProperty(value = "users")
    private List<User> users;
}
