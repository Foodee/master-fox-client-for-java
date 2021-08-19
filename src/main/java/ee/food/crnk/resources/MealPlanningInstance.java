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

@JsonApiResource(type = "meal-planning-instances")
@Data
public class MealPlanningInstance {

    public static MealPlanningInstance id(Long id) {
        val r = new MealPlanningInstance();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "plan")
    private Object plan;

    
    @JsonProperty(value = "name")
    private String name;

    
    @JsonProperty(value = "start-of-week")
    private Date startOfWeek;

    
    @JsonProperty(value = "build-group-orders")
    private Boolean buildGroupOrders;

    
    @JsonProperty(value = "new-weight")
    private Integer newWeight;

    
    @JsonProperty(value = "fav-weight")
    private Integer favWeight;

    
    @JsonProperty(value = "popularity-weight")
    private Integer popularityWeight;

    
    @JsonProperty(value = "last-week-weight")
    private Integer lastWeekWeight;

    
    @JsonProperty(value = "last-week-offset")
    private Integer lastWeekOffset;

    
    @JsonProperty(value = "max-uses-per-week")
    private Integer maxUsesPerWeek;

    
    @JsonProperty(value = "max-uses-per-day")
    private Integer maxUsesPerDay;

    
    @JsonProperty(value = "max-uses-per-meal")
    private Integer maxUsesPerMeal;

    
    @JsonProperty(value = "team-members-count")
    private Integer teamMembersCount;

    
    @JsonProperty(value = "allow-repeats")
    private Boolean allowRepeats;

    
    @JsonProperty(value = "use-team-profiles")
    private Boolean useTeamProfiles;

    
    @JsonProperty(value = "ignore-empty-constraints")
    private Boolean ignoreEmptyConstraints;

    
    @JsonProperty(value = "ignored-constraints")
    private Object ignoredConstraints;

    
    @JsonProperty(value = "disabled-preferences")
    private Boolean disabledPreferences;

    
    @JsonProperty(value = "excluded-preference-ids")
    private Object excludedPreferenceIds;

    
    @JsonProperty(value = "is-recurring")
    private Boolean isRecurring;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "client")
    private Client client;

    @JsonApiRelation
    @JsonProperty(value = "area")
    private Area area;

    @JsonApiRelation
    @JsonProperty(value = "meal-planning-template")
    private MealPlanningTemplate mealPlanningTemplate;

    @JsonApiRelation
    @JsonProperty(value = "preference-profile")
    private MealPlanningPreferenceProfile preferenceProfile;

    @JsonApiRelation
    @JsonProperty(value = "order-template")
    private Order orderTemplate;

    @JsonApiRelation
    @JsonProperty(value = "default-order-owner")
    private User defaultOrderOwner;

    @JsonApiRelation
    @JsonProperty(value = "meal-planning-reservations")
    private List<MealPlanningReservation> mealPlanningReservations;

    @JsonApiRelation
    @JsonProperty(value = "events")
    private List<MealPlanningEvent> events;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-constraints")
    private List<MealPlanningRestaurantConstraint> restaurantConstraints;

    @JsonApiRelation
    @JsonProperty(value = "team-members")
    private List<User> teamMembers;

    @JsonApiRelation
    @JsonProperty(value = "orders")
    private List<Order> orders;

    @JsonApiRelation
    @JsonProperty(value = "log-records")
    private List<MealPlanningLogRecord> logRecords;
}
