package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "meal-planning-requirements")
@Data
public class MealPlanningRequirement {

    public static MealPlanningRequirement id(Long id) {
        val r = new MealPlanningRequirement();
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

    @JsonProperty(value = "number-of-options")
    private Integer numberOfOptions;

    @JsonProperty(value = "number-of-people")
    private Integer numberOfPeople;

    @JsonProperty(value = "max-price")
    private Float maxPrice;

    @JsonProperty(value = "min-price")
    private Float minPrice;

    @JsonProperty(value = "active")
    private Boolean active;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "preference-profile")
    private MealPlanningPreferenceProfile preferenceProfile;

    @JsonApiRelation
    @JsonProperty(value = "requirement-group")
    private MealPlanningRequirementGroup requirementGroup;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-constraint")
    private MealPlanningRestaurantConstraint restaurantConstraint;

    @JsonApiRelation
    @JsonProperty(value = "order")
    private Order order;

    @JsonApiRelation
    @JsonProperty(value = "requirement-constraints")
    private List<MealPlanningRequirementConstraint> requirementConstraints;

    @JsonApiRelation
    @JsonProperty(value = "tags")
    private List<Tag> tags;

    @JsonApiRelation
    @JsonProperty(value = "dietary-tags")
    private List<DietaryTag> dietaryTags;

    @JsonApiRelation
    @JsonProperty(value = "allergy-tags")
    private List<DietaryTag> allergyTags;

    @JsonApiRelation
    @JsonProperty(value = "packaging-tags")
    private List<DietaryTag> packagingTags;

    @JsonApiRelation
    @JsonProperty(value = "food-types")
    private List<FoodType> foodTypes;

    @JsonApiRelation
    @JsonProperty(value = "meal-types")
    private List<MealType> mealTypes;
}
