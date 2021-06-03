package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "menu-items")
@Data
public class MenuItem {

    public static MenuItem id(Long id) {
        val r = new MenuItem();
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

    @JsonProperty(value = "created-at")
    private Date createdAt;

    @JsonProperty(value = "active")
    private Boolean active;

    @JsonProperty(value = "description")
    private Object description;

    @JsonProperty(value = "minimum-quantity")
    private Integer minimumQuantity;

    @JsonProperty(value = "maximum-quantity")
    private Integer maximumQuantity;

    @JsonProperty(value = "minimum-serving")
    private Integer minimumServing;

    @JsonProperty(value = "maximum-serving")
    private Integer maximumServing;

    @JsonProperty(value = "client-price-cents")
    private Integer clientPriceCents;

    @JsonProperty(value = "position")
    private Integer position;

    @JsonProperty(value = "restaurant-price-cents")
    private Integer restaurantPriceCents;

    @JsonProperty(value = "retail-price-cents")
    private Integer retailPriceCents;

    @JsonProperty(value = "internal-description")
    private String internalDescription;

    @JsonProperty(value = "tax-rate-id")
    private Integer taxRateId;

    @JsonProperty(value = "taxable")
    private Boolean taxable;

    @JsonProperty(value = "capacity-units")
    private Float capacityUnits;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "tax-rate")
    private InvoicingTaxRate taxRate;

    @JsonApiRelation
    @JsonProperty(value = "menu-group")
    private MenuGroup menuGroup;

    @JsonApiRelation
    @JsonProperty(value = "dietary-tags")
    private List<DietaryTag> dietaryTags;

    @JsonApiRelation
    @JsonProperty(value = "meal-types")
    private List<MealType> mealTypes;

    @JsonApiRelation
    @JsonProperty(value = "food-types")
    private List<FoodType> foodTypes;

    @JsonApiRelation
    @JsonProperty(value = "menu-option-groups")
    private List<MenuOptionGroup> menuOptionGroups;
}
