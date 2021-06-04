package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "logistics-deliveries")
@Data
public class LogisticsDelivery {

    public static LogisticsDelivery id(Long id) {
        val r = new LogisticsDelivery();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "alert-status")
    private String alertStatus;

    
    @JsonProperty(value = "allows-pay-out-of-pocket")
    private Boolean allowsPayOutOfPocket;

    
    @JsonProperty(value = "desk-cases")
    private Object deskCases;

    
    @JsonProperty(value = "delivery-cases")
    private Object deliveryCases;

    
    @JsonProperty(value = "deliver-at")
    private Date deliverAt;

    
    @JsonProperty(value = "delivered-at")
    private Date deliveredAt;

    
    @JsonProperty(value = "deliver-on")
    private Date deliverOn;

    
    @JsonProperty(value = "delivery-estimate")
    private Object deliveryEstimate;

    
    @JsonProperty(value = "flag")
    private Boolean flag;

    
    @JsonProperty(value = "identifier")
    private String identifier;

    
    @JsonProperty(value = "is-foodhall")
    private Boolean isFoodhall;

    
    @JsonProperty(value = "is-meal-plan-order")
    private Boolean isMealPlanOrder;

    
    @JsonProperty(value = "is-same-day")
    private Boolean isSameDay;

    
    @JsonProperty(value = "last-minute")
    private Boolean lastMinute;

    
    @JsonProperty(value = "logistics-type")
    private Integer logisticsType;

    
    @JsonProperty(value = "monitoring-notes")
    private String monitoringNotes;

    
    @JsonProperty(value = "notes")
    private String notes;

    
    @JsonProperty(value = "number-of-people")
    private Integer numberOfPeople;

    
    @JsonProperty(value = "order-images")
    private List<String> orderImages;

    
    @JsonProperty(value = "order-items")
    private Object orderItems;

    
    @JsonProperty(value = "order-type")
    private String orderType;

    
    @JsonProperty(value = "pickup-at")
    private Date pickupAt;

    
    @JsonProperty(value = "picked-up-at")
    private Date pickedUpAt;

    
    @JsonProperty(value = "state")
    private String state;

    
    @JsonProperty(value = "synced-with-third-party-logistics-at")
    private Date syncedWithThirdPartyLogisticsAt;

    
    @JsonProperty(value = "third-party-logistics-exception")
    private String thirdPartyLogisticsException;

    
    @JsonProperty(value = "third-party-logistics-id")
    private String thirdPartyLogisticsId;

    
    @JsonProperty(value = "third-party-logistics-tracking-url")
    private String thirdPartyLogisticsTrackingUrl;

    
    @JsonProperty(value = "total-amount")
    private Double totalAmount;

    
    @JsonProperty(value = "contact")
    private Object contact;

    
    @JsonProperty(value = "owner")
    private Object owner;

    
    @JsonProperty(value = "client")
    private Object client;

    
    @JsonProperty(value = "restaurant")
    private Object restaurant;

    
    @JsonProperty(value = "client-location")
    private Object clientLocation;

    
    @JsonProperty(value = "restaurant-location")
    private Object restaurantLocation;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "driver")
    private User driver;

    @JsonApiRelation
    @JsonProperty(value = "courier")
    private Courier courier;

    @JsonApiRelation
    @JsonProperty(value = "area")
    private Area area;

    @JsonApiRelation
    @JsonProperty(value = "order")
    private Order order;
}
