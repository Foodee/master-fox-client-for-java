package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "accounting-consolidation-runs")
@Data
public class AccountingConsolidationRun {

    public static AccountingConsolidationRun id(Long id) {
        val r = new AccountingConsolidationRun();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "ran-on")
    private Date ranOn;

    
    @JsonProperty(value = "identifier")
    private String identifier;

    
    @JsonProperty(value = "period")
    private String period;

    
    @JsonProperty(value = "query-type")
    private String queryType;

    
    @JsonProperty(value = "query-data")
    private String queryData;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "configuration")
    private AccountingConsolidationConfiguration configuration;

    @JsonApiRelation
    @JsonProperty(value = "invoice")
    private AccountingLedgerItem invoice;

    @JsonApiRelation
    @JsonProperty(value = "client")
    private Client client;
}
