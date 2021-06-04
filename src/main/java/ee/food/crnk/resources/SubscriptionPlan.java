package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "subscription-plans")
@Data
public class SubscriptionPlan {

    public static SubscriptionPlan id(Long id) {
        val r = new SubscriptionPlan();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "plan")
    private String plan;

    
    @JsonProperty(value = "price")
    private Integer price;

    
    @JsonProperty(value = "delivery-price")
    private Integer deliveryPrice;

    
    @JsonProperty(value = "plan-type")
    private String planType;

    
    @JsonProperty(value = "description")
    private Object description;

    
    @JsonProperty(value = "is-custom")
    private Boolean isCustom;

    
    @JsonProperty(value = "json-client-override")
    private Object jsonClientOverride;

    
    @JsonProperty(value = "cta-link")
    private String ctaLink;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "clients")
    private List<Client> clients;

    @JsonApiRelation
    @JsonProperty(value = "feature-flag-descriptions")
    private List<FeatureFlagDescription> featureFlagDescriptions;
}
