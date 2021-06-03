package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "accounting-consolidation-configurations")
@Data
public class AccountingConsolidationConfiguration {

    public static AccountingConsolidationConfiguration id(Long id) {
        val r = new AccountingConsolidationConfiguration();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "period")
    private String period;

    @JsonProperty(value = "query-type")
    private String queryType;

    @JsonProperty(value = "query-data")
    private String queryData;

    @JsonProperty(value = "first-run-on")
    private Date firstRunOn;

    @JsonProperty(value = "last-ran-on")
    private Date lastRanOn;

    @JsonProperty(value = "next-run-on")
    private Date nextRunOn;

    @JsonProperty(value = "currency")
    private String currency;

    @JsonProperty(value = "term-days")
    private Integer termDays;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "payment-card")
    private PaymentCard paymentCard;

    @JsonApiRelation
    @JsonProperty(value = "client")
    private Client client;

    @JsonApiRelation
    @JsonProperty(value = "runs")
    private List<AccountingConsolidationRun> runs;
}
