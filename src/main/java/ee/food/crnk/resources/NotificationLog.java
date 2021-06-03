package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "notification-logs")
@Data
public class NotificationLog {

    public static NotificationLog id(Long id) {
        val r = new NotificationLog();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "uniqueness-context")
    private String uniquenessContext;

    @JsonProperty(value = "medium")
    private Integer medium;

    @JsonProperty(value = "reason")
    private String reason;

    @JsonProperty(value = "created-at")
    private Date createdAt;

    @JsonProperty(value = "receiver-type")
    private String receiverType;

    @JsonProperty(value = "receiver-id")
    private Integer receiverId;

    @JsonProperty(value = "sent-tos")
    private List<String> sentTos;

    @JsonProperty(value = "events")
    private Object events;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "order")
    private Order order;
}
