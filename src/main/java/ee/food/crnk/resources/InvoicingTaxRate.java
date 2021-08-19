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

@JsonApiResource(type = "invoicing-tax-rates")
@Data
public class InvoicingTaxRate {

    public static InvoicingTaxRate id(Long id) {
        val r = new InvoicingTaxRate();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "name")
    private String name;

    
    @JsonProperty(value = "rate")
    private Double rate;

    
    @JsonProperty(value = "description")
    private String description;

    
    @JsonProperty(value = "is-default")
    private Boolean isDefault;

    
    @JsonProperty(value = "tax-code")
    private String taxCode;

    
    @JsonProperty(value = "valid-from")
    private Date validFrom;

    
    @JsonProperty(value = "valid-until")
    private Date validUntil;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "areas")
    private List<Area> areas;
}
