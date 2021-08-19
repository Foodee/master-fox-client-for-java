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

@JsonApiResource(type = "group-order-members")
@Data
public class GroupOrderMember {

    public static GroupOrderMember id(Long id) {
        val r = new GroupOrderMember();
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

    
    @JsonProperty(value = "email")
    private String email;

    
    @JsonProperty(value = "phone-number")
    private String phoneNumber;

    
    @JsonProperty(value = "department")
    private String department;

    
    @JsonProperty(value = "terms-accepted-at")
    private Date termsAcceptedAt;

    
    @JsonProperty(value = "stripe-charge-token")
    private String stripeChargeToken;

    
    @JsonProperty(value = "number-of-people")
    private Integer numberOfPeople;

    
    @JsonProperty(value = "notify-by-email-on-delivery")
    private Boolean notifyByEmailOnDelivery;

    
    @JsonProperty(value = "notify-by-sms-on-delivery")
    private Boolean notifyBySMSOnDelivery;

    
    @JsonProperty(value = "custom-fields")
    private Object customFields;

    
    @JsonProperty(value = "notification-preferences")
    private Object notificationPreferences;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "user")
    private User user;

    @JsonApiRelation
    @JsonProperty(value = "order")
    private Order order;

    @JsonApiRelation
    @JsonProperty(value = "invoice")
    private AccountingLedgerItem invoice;

    @JsonApiRelation
    @JsonProperty(value = "order-items")
    private List<OrderItem> orderItems;
}
