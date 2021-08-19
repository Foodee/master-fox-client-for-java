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

@JsonApiResource(type = "meal-planning-restaurant-constraints")
@Data
public class MealPlanningRestaurantConstraint {

    public static MealPlanningRestaurantConstraint id(Long id) {
        val r = new MealPlanningRestaurantConstraint();
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

    
    @JsonProperty(value = "value")
    private Integer value;

    
    @JsonProperty(value = "constraint-type")
    private String constraintType;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "template")
    private MealPlanningTemplate template;

    @JsonApiRelation
    @JsonProperty(value = "instance")
    private MealPlanningInstance instance;

    @JsonApiRelation
    @JsonProperty(value = "event")
    private MealPlanningEvent event;

    @JsonApiRelation
    @JsonProperty(value = "requirement")
    private MealPlanningRequirement requirement;

    @JsonApiRelation
    @JsonProperty(value = "restaurants")
    private List<Restaurant> restaurants;
}
