package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "email-messages")
@Data
public class EmailMessage {

    public static EmailMessage id(Long id) {
        val r = new EmailMessage();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "message-id")
    private String messageId;

    
    @JsonProperty(value = "recipients")
    private List<String> recipients;

    
    @JsonProperty(value = "message")
    private String message;

    
    @JsonProperty(value = "subject")
    private String subject;

    
    @JsonProperty(value = "event")
    private String event;

    
    @JsonProperty(value = "mailable-id")
    private Integer mailableId;

    
    @JsonProperty(value = "timestamp")
    private Date timestamp;

    
    @JsonProperty(value = "message-type")
    private String messageType;

    
    @JsonProperty(value = "created-at")
    private Date createdAt;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "order")
    private Order order;
}
