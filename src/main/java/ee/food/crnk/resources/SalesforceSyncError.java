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

@JsonApiResource(type = "salesforce-sync-errors")
@Data
public class SalesforceSyncError {

    public static SalesforceSyncError id(Long id) {
        val r = new SalesforceSyncError();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "log")
    private Object log;

    
    @JsonProperty(value = "record-id")
    private Integer recordId;

    
    @JsonProperty(value = "record-type")
    private String recordType;

    
    @JsonProperty(value = "is-resolved")
    private Boolean isResolved;

    
    @JsonProperty(value = "created-at")
    private Date createdAt;

    
    @JsonProperty(value = "updated-at")
    private Date updatedAt;

    /********************************************
     * Relationships
     ********************************************/
}
