package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "couriers")
@Data
public class Courier {

    public static Courier id(Long id) {
        val r = new Courier();
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

    
    @JsonProperty(value = "legal-name")
    private String legalName;

    
    @JsonProperty(value = "api-type")
    private String apiType;

    
    @JsonProperty(value = "always-sync")
    private Boolean alwaysSync;

    
    @JsonProperty(value = "third-party-logistics-configuration")
    private Object thirdPartyLogisticsConfiguration;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "owner")
    private User owner;

    @JsonApiRelation
    @JsonProperty(value = "drivers")
    private List<User> drivers;

    @JsonApiRelation
    @JsonProperty(value = "areas")
    private List<Area> areas;

    @JsonApiRelation
    @JsonProperty(value = "versions")
    private List<HistorianVersion> versions;
}
