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

@JsonApiResource(type = "delivery-locations")
@Data
public class DeliveryLocation {

    public static DeliveryLocation id(Long id) {
        val r = new DeliveryLocation();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "location-id")
    private Integer locationId;

    
    @JsonProperty(value = "default")
    private Boolean isDefault;

    
    @JsonProperty(value = "updated-at")
    private Date updatedAt;

    
    @JsonProperty(value = "notes")
    private Object notes;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "client")
    private Client client;

    @JsonApiRelation
    @JsonProperty(value = "location")
    private Location location;
}
