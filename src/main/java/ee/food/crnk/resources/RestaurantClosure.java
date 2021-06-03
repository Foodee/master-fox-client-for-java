package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "restaurant-closures")
@Data
public class RestaurantClosure {

    public static RestaurantClosure id(Long id) {
        val r = new RestaurantClosure();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "created-at")
    private Date createdAt;

    @JsonProperty(value = "updated-at")
    private Date updatedAt;

    @JsonProperty(value = "date")
    private Date date;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "restaurant")
    private Restaurant restaurant;
}
