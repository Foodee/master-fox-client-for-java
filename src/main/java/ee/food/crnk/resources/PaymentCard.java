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

@JsonApiResource(type = "payment-cards")
@Data
public class PaymentCard {

    public static PaymentCard id(Long id) {
        val r = new PaymentCard();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "position")
    private Integer position;

    
    @JsonProperty(value = "last-four-digits")
    private Integer lastFourDigits;

    
    @JsonProperty(value = "expiry-month")
    private Integer expiryMonth;

    
    @JsonProperty(value = "expiry-year")
    private Integer expiryYear;

    
    @JsonProperty(value = "card-type")
    private String cardType;

    
    @JsonProperty(value = "default")
    private Boolean isDefault;

    
    @JsonProperty(value = "name-on-card")
    private String nameOnCard;

    
    @JsonProperty(value = "nickname")
    private String nickname;

    
    @JsonProperty(value = "removed")
    private Boolean removed;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "client")
    private Client client;

    @JsonApiRelation
    @JsonProperty(value = "user")
    private User user;
}
