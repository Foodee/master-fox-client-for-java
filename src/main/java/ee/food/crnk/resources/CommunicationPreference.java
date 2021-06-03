package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "communication-preferences")
@Data
public class CommunicationPreference {

    public static CommunicationPreference id(Long id) {
        val r = new CommunicationPreference();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "sms")
    private Boolean sms;

    @JsonProperty(value = "email-feedback")
    private Boolean emailFeedback;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "user")
    private User user;
}
