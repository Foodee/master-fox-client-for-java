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

@JsonApiResource(type = "menu-option-items")
@Data
public class MenuOptionItem {

    public static MenuOptionItem id(Long id) {
        val r = new MenuOptionItem();
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

    
    @JsonProperty(value = "client-price-cents")
    private Double clientPriceCents;

    
    @JsonProperty(value = "deleted-at")
    private Date deletedAt;

    
    @JsonProperty(value = "restaurant-price-cents")
    private Double restaurantPriceCents;

    
    @JsonProperty(value = "retail-price-cents")
    private Double retailPriceCents;

    
    @JsonProperty(value = "position")
    private Integer position;

    @JsonIgnore
    @JsonProperty(value = "client-price")
    private Money clientPrice;

    @JsonIgnore
    @JsonProperty(value = "restaurant-price")
    private Money restaurantPrice;

    @JsonIgnore
    @JsonProperty(value = "retail-price")
    private Money retailPrice;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "menu-option-group")
    private MenuOptionGroup menuOptionGroup;

    @JsonApiRelation
    @JsonProperty(value = "dietary-tags")
    private List<DietaryTag> dietaryTags;

    @JsonApiRelation
    @JsonProperty(value = "order-items")
    private List<OrderItem> orderItems;
}
