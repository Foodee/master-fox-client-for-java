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

@JsonApiResource(type = "restaurant-discounts")
@Data
public class RestaurantDiscount {

    public static RestaurantDiscount id(Long id) {
        val r = new RestaurantDiscount();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "accounting-code")
    private String accountingCode;

    
    @JsonProperty(value = "amount")
    private Double amount;

    
    @JsonProperty(value = "amount-type")
    private String amountType;

    
    @JsonProperty(value = "case-id")
    private String caseId;

    
    @JsonProperty(value = "description")
    private Object description;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "order")
    private Order order;
}
