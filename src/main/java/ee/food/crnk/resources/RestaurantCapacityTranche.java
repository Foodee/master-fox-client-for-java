package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "restaurant-capacity-tranches")
@Data
public class RestaurantCapacityTranche {

    public static RestaurantCapacityTranche id(Long id) {
        val r = new RestaurantCapacityTranche();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "start-time")
    private Object startTime;

    @JsonProperty(value = "end-time")
    private Object endTime;

    @JsonProperty(value = "capacity")
    private Float capacity;

    @JsonProperty(value = "order-max")
    private Integer orderMax;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "restaurant")
    private Restaurant restaurant;
}
