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

@JsonApiResource(type = "meal-planning-reservations")
@Data
public class MealPlanningReservation {

    public static MealPlanningReservation id(Long id) {
        val r = new MealPlanningReservation();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "state")
    private String state;

    
    @JsonProperty(value = "deliver-at")
    private Date deliverAt;

    
    @JsonProperty(value = "pickup-at")
    private Date pickupAt;

    
    @JsonProperty(value = "number-of-people")
    private Integer numberOfPeople;

    
    @JsonProperty(value = "ignores-capacity-limit")
    private Boolean ignoresCapacityLimit;

    
    @JsonProperty(value = "created-at")
    private Date createdAt;

    
    @JsonProperty(value = "updated-at")
    private Date updatedAt;

    
    @JsonProperty(value = "favourite")
    private Boolean favourite;

    
    @JsonProperty(value = "favourite-count")
    private Integer favouriteCount;

    
    @JsonProperty(value = "favourite-cuisine")
    private Boolean favouriteCuisine;

    
    @JsonProperty(value = "favourite-cuisine-count")
    private Integer favouriteCuisineCount;

    
    @JsonProperty(value = "last-week")
    private Boolean lastWeek;

    
    @JsonProperty(value = "first")
    private Boolean first;

    
    @JsonProperty(value = "percent-rank")
    private Float percentRank;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "area")
    private Area area;

    @JsonApiRelation
    @JsonProperty(value = "client")
    private Client client;

    @JsonApiRelation
    @JsonProperty(value = "restaurant")
    private Restaurant restaurant;

    @JsonApiRelation
    @JsonProperty(value = "meal-planning-instance")
    private MealPlanningInstance mealPlanningInstance;

    @JsonApiRelation
    @JsonProperty(value = "event")
    private MealPlanningEvent event;

    @JsonApiRelation
    @JsonProperty(value = "order")
    private Order order;
}
