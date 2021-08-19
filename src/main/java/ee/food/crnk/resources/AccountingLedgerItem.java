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

@JsonApiResource(type = "accounting-ledger-items")
@Data
public class AccountingLedgerItem {

    public static AccountingLedgerItem id(Long id) {
        val r = new AccountingLedgerItem();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "identifier")
    private String identifier;

    
    @JsonProperty(value = "status")
    private String status;

    
    @JsonProperty(value = "issue-date")
    private Date issueDate;

    
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

    
    @JsonProperty(value = "xero-id")
    private UUID xeroId;

    
    @JsonProperty(value = "created-at")
    private Date createdAt;

    
    @JsonProperty(value = "updated-at")
    private Date updatedAt;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "parent")
    private AccountingLedgerItem parent;

    @JsonApiRelation
    @JsonProperty(value = "line-items")
    private List<AccountingLineItem> lineItems;

    @JsonApiRelation
    @JsonProperty(value = "children")
    private List<AccountingLedgerItem> children;
}
