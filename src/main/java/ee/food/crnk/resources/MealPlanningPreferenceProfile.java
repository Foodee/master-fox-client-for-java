package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "meal-planning-preference-profiles")
@Data
public class MealPlanningPreferenceProfile {

    public static MealPlanningPreferenceProfile id(Long id) {
        val r = new MealPlanningPreferenceProfile();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "search-budget-enabled")
    private Boolean searchBudgetEnabled;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "requirements")
    private List<MealPlanningRequirement> requirements;

    @JsonApiRelation
    @JsonProperty(value = "requirement-groups")
    private List<MealPlanningRequirementGroup> requirementGroups;

    @JsonApiRelation
    @JsonProperty(value = "loved-restaurants")
    private List<Restaurant> lovedRestaurants;

    @JsonApiRelation
    @JsonProperty(value = "hated-restaurants")
    private List<Restaurant> hatedRestaurants;

    @JsonApiRelation
    @JsonProperty(value = "loved-cuisine-types")
    private List<Tag> lovedCuisineTypes;

    @JsonApiRelation
    @JsonProperty(value = "hated-cuisine-types")
    private List<Tag> hatedCuisineTypes;
}
