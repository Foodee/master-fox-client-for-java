package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "desk-cases")
@Data
public class DeskCase {

    public static DeskCase id(Long id) {
        val r = new DeskCase();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "case-request")
    private String caseRequest;

    @JsonProperty(value = "case-id")
    private Integer caseId;

    @JsonProperty(value = "case-message")
    private String caseMessage;

    @JsonProperty(value = "case-status")
    private String caseStatus;

    @JsonProperty(value = "case-value")
    private Integer caseValue;

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
