package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "logistics-arrival-estimates")
@Data
public class LogisticsArrivalEstimate {

    public static LogisticsArrivalEstimate id(Long id) {
        val r = new LogisticsArrivalEstimate();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "order-id")
    private Integer orderId;

    /********************************************
     * Relationships
     ********************************************/
}
