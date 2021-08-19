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

@JsonApiResource(type = "currencies-transactions")
@Data
public class CurrenciesTransaction {

    public static CurrenciesTransaction id(Long id) {
        val r = new CurrenciesTransaction();
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

    
    @JsonProperty(value = "reason")
    private Object reason;

    
    @JsonProperty(value = "event")
    private String event;

    /********************************************
     * Relationships
     ********************************************/
}
