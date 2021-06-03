package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "areas")
@Data
public class Area {

    public static Area id(Long id) {
        val r = new Area();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "active")
    private Boolean active;

    @JsonProperty(value = "country")
    private String country;

    @JsonProperty(value = "province")
    private String province;

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value = "district")
    private String district;

    @JsonProperty(value = "slug")
    private String slug;

    @JsonProperty(value = "iso-time-zone")
    private String isoTimeZone;

    @JsonProperty(value = "delivery-lead-time")
    private Integer deliveryLeadTime;

    @JsonProperty(value = "park-and-load-time")
    private Integer parkAndLoadTime;

    @JsonProperty(value = "currency")
    private String currency;

    @JsonProperty(value = "delivery-zone")
    private Map<String, Object> deliveryZone;

    @JsonProperty(value = "created-at")
    private Date createdAt;

    @JsonProperty(value = "prefix")
    private String prefix;

    @JsonProperty(value = "cover-image-url")
    private String coverImageUrl;

    @JsonProperty(value = "is-internal")
    private Boolean isInternal;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "delivery-fee-tax-rate")
    private InvoicingTaxRate deliveryFeeTaxRate;

    @JsonApiRelation
    @JsonProperty(value = "couriers")
    private List<Courier> couriers;

    @JsonApiRelation
    @JsonProperty(value = "clients")
    private List<Client> clients;

    @JsonApiRelation
    @JsonProperty(value = "restaurants")
    private List<Restaurant> restaurants;

    @JsonApiRelation
    @JsonProperty(value = "invoicing-tax-rates")
    private List<InvoicingTaxRate> invoicingTaxRates;

    @JsonApiRelation
    @JsonProperty(value = "global-invoicing-tax-rates")
    private List<InvoicingTaxRate> globalInvoicingTaxRates;

    @JsonApiRelation
    @JsonProperty(value = "area-closures")
    private List<AreaClosure> areaClosures;

    @JsonApiRelation
    @JsonProperty(value = "current-week-area-closures")
    private List<AreaClosure> currentWeekAreaClosures;

    @JsonApiRelation
    @JsonProperty(value = "promo-codes")
    private List<PromoCode> promoCodes;

    @JsonApiRelation
    @JsonProperty(value = "orders")
    private List<Order> orders;

    @JsonApiRelation
    @JsonProperty(value = "versions")
    private List<HistorianVersion> versions;

    @JsonApiRelation
    @JsonProperty(value = "all-area-versions")
    private List<HistorianVersion> allAreaVersions;
}
