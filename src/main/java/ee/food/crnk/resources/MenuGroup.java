package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "menu-groups")
@Data
public class MenuGroup {

    public static MenuGroup id(Long id) {
        val r = new MenuGroup();
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

    
    @JsonProperty(value = "active")
    private Boolean active;

    
    @JsonProperty(value = "internal")
    private Boolean internal;

    
    @JsonProperty(value = "is-cutlery")
    private Boolean isCutlery;

    
    @JsonProperty(value = "description")
    private Object description;

    
    @JsonProperty(value = "position")
    private Integer position;

    
    @JsonProperty(value = "minimum-quantity")
    private Integer minimumQuantity;

    
    @JsonProperty(value = "maximum-quantity")
    private Integer maximumQuantity;

    
    @JsonProperty(value = "minimum-serving")
    private Integer minimumServing;

    
    @JsonProperty(value = "maximum-serving")
    private Integer maximumServing;

    
    @JsonProperty(value = "created-at")
    private Date createdAt;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "menu")
    private Menu menu;

    @JsonApiRelation
    @JsonProperty(value = "menu-items")
    private List<MenuItem> menuItems;

    @JsonApiRelation
    @JsonProperty(value = "meal-types")
    private List<MealType> mealTypes;

    @JsonApiRelation
    @JsonProperty(value = "food-types")
    private List<FoodType> foodTypes;
}
