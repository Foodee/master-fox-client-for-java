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

@JsonApiResource(type = "promo-codes")
@Data
public class PromoCode {

    public static PromoCode id(Long id) {
        val r = new PromoCode();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "code")
    private String code;

    
    @JsonProperty(value = "amount")
    private Double amount;

    
    @JsonProperty(value = "amount-type")
    private String amountType;

    
    @JsonProperty(value = "expires-at")
    private Date expiresAt;

    
    @JsonProperty(value = "internal")
    private Boolean internal;

    
    @JsonProperty(value = "allow-multiple-client-uses")
    private Boolean allowMultipleClientUses;

    
    @JsonProperty(value = "description")
    private Object description;

    
    @JsonProperty(value = "removed")
    private Boolean removed;

    
    @JsonProperty(value = "starts-at")
    private Date startsAt;

    
    @JsonProperty(value = "client-accounting-code")
    private Integer clientAccountingCode;

    
    @JsonProperty(value = "restaurant-accounting-code")
    private Integer restaurantAccountingCode;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "area")
    private Area area;

    @JsonApiRelation
    @JsonProperty(value = "restaurant")
    private Restaurant restaurant;

    @JsonApiRelation
    @JsonProperty(value = "order")
    private List<Order> order;

    @JsonApiRelation
    @JsonProperty(value = "versions")
    private List<HistorianVersion> versions;
}
