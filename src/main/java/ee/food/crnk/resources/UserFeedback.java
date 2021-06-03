package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "user-feedbacks")
@Data
public class UserFeedback {

    public static UserFeedback id(Long id) {
        val r = new UserFeedback();
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

    /********************************************
     * Relationships
     ********************************************/
}
