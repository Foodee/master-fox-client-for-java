package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "accounting-line-items")
@Data
public class AccountingLineItem {

    public static AccountingLineItem id(Long id) {
        val r = new AccountingLineItem();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "quantity")
    private Integer quantity;

    @JsonProperty(value = "net-amount")
    private Double netAmount;

    @JsonProperty(value = "tax-amount")
    private Double taxAmount;

    @JsonProperty(value = "tax-rate")
    private String taxRate;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "notes")
    private String notes;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "ledger-item")
    private AccountingLedgerItem ledgerItem;
}
