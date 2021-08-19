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

@JsonApiResource(type = "teams")
@Data
public class Team {

    public static Team id(Long id) {
        val r = new Team();
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

    
    @JsonProperty(value = "accounting-code")
    private String accountingCode;

    
    @JsonProperty(value = "is-active")
    private Boolean isActive;

    
    @JsonProperty(value = "is-default")
    private Boolean isDefault;

    
    @JsonProperty(value = "managed-internally")
    private Boolean managedInternally;

    
    @JsonProperty(value = "per-person-budget")
    private Float perPersonBudget;

    
    @JsonProperty(value = "dietary-composition")
    private Object dietaryComposition;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "client")
    private Client client;

    @JsonApiRelation
    @JsonProperty(value = "members")
    private List<User> members;

    @JsonApiRelation
    @JsonProperty(value = "orders")
    private List<Order> orders;

    @JsonApiRelation
    @JsonProperty(value = "member-profiles")
    private List<MealPlanningPreferenceProfile> memberProfiles;
}
