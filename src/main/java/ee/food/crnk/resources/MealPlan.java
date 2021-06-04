package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "meal-plans")
@Data
public class MealPlan {

    public static MealPlan id(Long id) {
        val r = new MealPlan();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "brand-color")
    private String brandColor;

    
    @JsonProperty(value = "custom-css")
    private Object customCss;

    
    @JsonProperty(value = "display-name")
    private String displayName;

    
    @JsonProperty(value = "name-label")
    private String nameLabel;

    
    @JsonProperty(value = "name-label-placeholder")
    private String nameLabelPlaceholder;

    
    @JsonProperty(value = "logo-url")
    private String logoUrl;

    
    @JsonProperty(value = "vanity-url")
    private String vanityUrl;

    
    @JsonProperty(value = "email-domain")
    private String emailDomain;

    
    @JsonProperty(value = "created-at")
    private Date createdAt;

    
    @JsonProperty(value = "updated-at")
    private Date updatedAt;

    
    @JsonProperty(value = "default-opens-at-lead-time")
    private Float defaultOpensAtLeadTime;

    
    @JsonProperty(value = "always-request-department")
    private Boolean alwaysRequestDepartment;

    
    @JsonProperty(value = "department-label")
    private String departmentLabel;

    
    @JsonProperty(value = "department-options")
    private List<String> departmentOptions;

    
    @JsonProperty(value = "is-department-required")
    private Boolean isDepartmentRequired;

    
    @JsonProperty(value = "sso-type")
    private String ssoType;

    
    @JsonProperty(value = "saml-settings")
    private Object samlSettings;

    
    @JsonProperty(value = "oauth-settings")
    private Object oauthSettings;

    
    @JsonProperty(value = "custom-fields")
    private Object customFields;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "meal-plan-user")
    private User mealPlanUser;

    @JsonApiRelation
    @JsonProperty(value = "client")
    private Client client;

    @JsonApiRelation
    @JsonProperty(value = "orders")
    private List<Order> orders;
}
