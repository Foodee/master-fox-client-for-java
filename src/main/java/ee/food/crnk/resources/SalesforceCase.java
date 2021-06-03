package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "salesforce-cases")
@Data
public class SalesforceCase {

    public static SalesforceCase id(Long id) {
        val r = new SalesforceCase();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "status")
    private String status;

    @JsonProperty(value = "origin")
    private String origin;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "subject")
    private String subject;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "order")
    private Order order;
}
