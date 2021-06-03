package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "meal-planning-templates")
@Data
public class MealPlanningTemplate {

    public static MealPlanningTemplate id(Long id) {
        val r = new MealPlanningTemplate();
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

    @JsonProperty(value = "contact")
    private Object contact;

    @JsonProperty(value = "location")
    private Object location;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "default-number-of-people")
    private Integer defaultNumberOfPeople;

    @JsonProperty(value = "build-group-orders")
    private Boolean buildGroupOrders;

    @JsonProperty(value = "new-weight")
    private Integer newWeight;

    @JsonProperty(value = "popularity-weight")
    private Integer popularityWeight;

    @JsonProperty(value = "fav-weight")
    private Integer favWeight;

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

    @JsonProperty(value = "allow-repeats")
    private Boolean allowRepeats;

    @JsonProperty(value = "use-team-profiles")
    private Boolean useTeamProfiles;

    @JsonProperty(value = "ignore-empty-constraints")
    private Boolean ignoreEmptyConstraints;

    @JsonProperty(value = "is-recurring")
    private Boolean isRecurring;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "client")
    private Client client;

    @JsonApiRelation
    @JsonProperty(value = "order-template")
    private Order orderTemplate;

    @JsonApiRelation
    @JsonProperty(value = "area")
    private Area area;

    @JsonApiRelation
    @JsonProperty(value = "preference-profile")
    private MealPlanningPreferenceProfile preferenceProfile;

    @JsonApiRelation
    @JsonProperty(value = "schedule")
    private MealPlanningSchedule schedule;

    @JsonApiRelation
    @JsonProperty(value = "default-order-owner")
    private User defaultOrderOwner;

    @JsonApiRelation
    @JsonProperty(value = "meal-planning-instances")
    private List<MealPlanningInstance> mealPlanningInstances;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-constraints")
    private List<MealPlanningRestaurantConstraint> restaurantConstraints;
}
