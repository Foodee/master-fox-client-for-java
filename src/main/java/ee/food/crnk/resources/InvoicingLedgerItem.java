package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "invoicing-ledger-items")
@Data
public class InvoicingLedgerItem {

    public static InvoicingLedgerItem id(Long id) {
        val r = new InvoicingLedgerItem();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "issue-date")
    private Date issueDate;

    
    @JsonProperty(value = "identifier")
    private String identifier;

    
    @JsonProperty(value = "currency")
    private String currency;

    
    @JsonProperty(value = "total-amount")
    private Double totalAmount;

    
    @JsonProperty(value = "tax-amount")
    private Double taxAmount;

    
    @JsonProperty(value = "description")
    private String description;

    
    @JsonProperty(value = "due-date")
    private Date dueDate;

    
    @JsonProperty(value = "status")
    private String status;

    
    @JsonProperty(value = "custom-fields")
    private Object customFields;

    
    @JsonProperty(value = "sender-details")
    private Object senderDetails;

    
    @JsonProperty(value = "pdf")
    private String pdf;

    
    @JsonProperty(value = "xero-id")
    private UUID xeroId;

    /********************************************
     * Relationships
     ********************************************/
}
