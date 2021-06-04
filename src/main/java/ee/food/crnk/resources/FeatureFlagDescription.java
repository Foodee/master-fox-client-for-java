package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "feature-flag-descriptions")
@Data
public class FeatureFlagDescription {

    public static FeatureFlagDescription id(Long id) {
        val r = new FeatureFlagDescription();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "flag-id")
    private String flagId;

    
    @JsonProperty(value = "description")
    private Object description;

    
    @JsonProperty(value = "is-plan-feature")
    private Boolean isPlanFeature;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "subscription-plans")
    private List<SubscriptionPlan> subscriptionPlans;
}
