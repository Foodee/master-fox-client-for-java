package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "historian-versions")
@Data
public class HistorianVersion {

    public static HistorianVersion id(Long id) {
        val r = new HistorianVersion();
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

    
    @JsonProperty(value = "item-type")
    private String itemType;

    
    @JsonProperty(value = "item-id")
    private Integer itemId;

    
    @JsonProperty(value = "event")
    private String event;

    
    @JsonProperty(value = "object")
    private Object object;

    
    @JsonProperty(value = "object-changes")
    private Object objectChanges;

    
    @JsonProperty(value = "misc")
    private Object misc;

    
    @JsonProperty(value = "whodunnit")
    private String whodunnit;

    /********************************************
     * Relationships
     ********************************************/
}
