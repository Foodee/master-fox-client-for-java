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

@JsonApiResource(type = "client-signups")
@Data
public class ClientSignup {

    public static ClientSignup id(Long id) {
        val r = new ClientSignup();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "user")
    private User user;

    @JsonApiRelation
    @JsonProperty(value = "qualifying-question")
    private QualifyingQuestion qualifyingQuestion;

    @JsonApiRelation
    @JsonProperty(value = "billing-location")
    private Location billingLocation;

    @JsonApiRelation
    @JsonProperty(value = "delivery-location")
    private Location deliveryLocation;

    @JsonApiRelation
    @JsonProperty(value = "billing-contact")
    private Contact billingContact;

    @JsonApiRelation
    @JsonProperty(value = "contact")
    private Contact contact;

    @JsonApiRelation
    @JsonProperty(value = "clients")
    private List<Client> clients;

    @JsonApiRelation
    @JsonProperty(value = "areas")
    private List<Area> areas;
}
