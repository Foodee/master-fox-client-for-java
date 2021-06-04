package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "order-items")
@Data
public class OrderItem {

    public static OrderItem id(Long id) {
        val r = new OrderItem();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "quantity")
    private Integer quantity;

    
    @JsonProperty(value = "notes")
    private String notes;

    
    @JsonProperty(value = "client-price-cents")
    private Integer clientPriceCents;

    
    @JsonProperty(value = "taxable")
    private Boolean taxable;

    
    @JsonProperty(value = "override-prices")
    private Boolean overridePrices;

    
    @JsonProperty(value = "capacity-units")
    private Float capacityUnits;

    
    @JsonProperty(value = "restaurant-price-cents")
    private Integer restaurantPriceCents;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "order")
    private Order order;

    @JsonApiRelation
    @JsonProperty(value = "menu-item")
    private MenuItem menuItem;

    @JsonApiRelation
    @JsonProperty(value = "group-order-member")
    private GroupOrderMember groupOrderMember;

    @JsonApiRelation
    @JsonProperty(value = "menu-option-items")
    private List<MenuOptionItem> menuOptionItems;
}
