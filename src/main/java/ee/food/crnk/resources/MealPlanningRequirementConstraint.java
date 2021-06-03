package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "meal-planning-requirement-constraints")
@Data
public class MealPlanningRequirementConstraint {

    public static MealPlanningRequirementConstraint id(Long id) {
        val r = new MealPlanningRequirementConstraint();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "tag-type")
    private String tagType;

    @JsonProperty(value = "constraint-type")
    private String constraintType;

    @JsonProperty(value = "is-readonly")
    private Boolean isReadonly;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "requirement")
    private MealPlanningRequirement requirement;

    @JsonApiRelation
    @JsonProperty(value = "meal-types")
    private List<MealType> mealTypes;

    @JsonApiRelation
    @JsonProperty(value = "food-types")
    private List<FoodType> foodTypes;

    @JsonApiRelation
    @JsonProperty(value = "dietary-tags")
    private List<DietaryTag> dietaryTags;

    @JsonApiRelation
    @JsonProperty(value = "allergy-tags")
    private List<DietaryTag> allergyTags;

    @JsonApiRelation
    @JsonProperty(value = "packaging-tags")
    private List<DietaryTag> packagingTags;
}
