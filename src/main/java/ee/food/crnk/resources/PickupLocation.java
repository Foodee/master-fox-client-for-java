package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "pickup-locations")
@Data
public class PickupLocation {

    public static PickupLocation id(Long id) {
        val r = new PickupLocation();
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

    @JsonProperty(value = "notes")
    private Object notes;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "restaurant")
    private Restaurant restaurant;

    @JsonApiRelation
    @JsonProperty(value = "location")
    private Location location;
}
