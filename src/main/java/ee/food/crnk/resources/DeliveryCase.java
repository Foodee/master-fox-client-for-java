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

@JsonApiResource(type = "delivery-cases")
@Data
public class DeliveryCase {

    public static DeliveryCase id(Long id) {
        val r = new DeliveryCase();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "case-type")
    private String caseType;

    
    @JsonProperty(value = "value")
    private Integer value;

    
    @JsonProperty(value = "created-at")
    private Date createdAt;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "user")
    private User user;

    @JsonApiRelation
    @JsonProperty(value = "order")
    private Order order;
}
