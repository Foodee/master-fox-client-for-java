package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "contacts")
@Data
public class Contact {

    public static Contact id(Long id) {
        val r = new Contact();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "first-name")
    private String firstName;

    @JsonProperty(value = "last-name")
    private String lastName;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "extension")
    private String extension;

    @JsonProperty(value = "phone-number")
    private String phoneNumber;

    @JsonProperty(value = "sms-number")
    private String smsNumber;

    @JsonProperty(value = "updated-at")
    private Date updatedAt;

    /********************************************
     * Relationships
     ********************************************/
}
