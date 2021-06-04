package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "service-times")
@Data
public class ServiceTime {

    public static ServiceTime id(Long id) {
        val r = new ServiceTime();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "weekday")
    private Integer weekday;

    
    @JsonProperty(value = "delivery-start-time")
    private Object deliveryStartTime;

    
    @JsonProperty(value = "delivery-end-time")
    private Object deliveryEndTime;

    
    @JsonProperty(value = "pickup-start-time")
    private Object pickupStartTime;

    
    @JsonProperty(value = "pickup-end-time")
    private Object pickupEndTime;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "restaurant")
    private Restaurant restaurant;
}
