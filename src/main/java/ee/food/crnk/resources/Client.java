package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "clients")
@Data
public class Client {

    public static Client id(Long id) {
        val r = new Client();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "notes")
    private Object notes;

    @JsonProperty(value = "very-late-score")
    private Object veryLateScore;

    @JsonProperty(value = "actual-segment")
    private Integer actualSegment;

    @JsonProperty(value = "sales-support-client")
    private Boolean salesSupportClient;

    @JsonProperty(value = "updated-at")
    private Date updatedAt;

    @JsonProperty(value = "xero-contact-id")
    private UUID xeroContactId;

    @JsonProperty(value = "xero-synchronized-at")
    private Date xeroSynchronizedAt;

    @JsonProperty(value = "waive-delivery-fee")
    private Boolean waiveDeliveryFee;

    @JsonProperty(value = "waive-service-fee")
    private Boolean waiveServiceFee;

    @JsonProperty(value = "waive-delivery-fee-accounting-code")
    private String waiveDeliveryFeeAccountingCode;

    @JsonProperty(value = "waive-service-fee-accounting-code")
    private String waiveServiceFeeAccountingCode;

    @JsonProperty(value = "waive-delivery-fee-description")
    private String waiveDeliveryFeeDescription;

    @JsonProperty(value = "waive-service-fee-description")
    private String waiveServiceFeeDescription;

    @JsonProperty(value = "uuid")
    private UUID uuid;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "legal-name")
    private String legalName;

    @JsonProperty(value = "delivery-notes")
    private Object deliveryNotes;

    @JsonProperty(value = "plan")
    private String plan;

    @JsonProperty(value = "terms")
    private Boolean terms;

    @JsonProperty(value = "term-days")
    private Integer termDays;

    @JsonProperty(value = "api-token")
    private String apiToken;

    @JsonProperty(value = "is-paying-service-fee")
    private Boolean isPayingServiceFee;

    @JsonProperty(value = "cutlery-preference")
    private String cutleryPreference;

    @JsonProperty(value = "manage-teams")
    private Boolean manageTeams;

    @JsonProperty(value = "limit-share-notifications")
    private Boolean limitShareNotifications;

    @JsonProperty(value = "storage")
    private Object storage;

    @JsonProperty(value = "state")
    private String state;

    @JsonProperty(value = "orders-count")
    private Integer ordersCount;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "default-area")
    private Area defaultArea;

    @JsonApiRelation
    @JsonProperty(value = "billing-location")
    private Location billingLocation;

    @JsonApiRelation
    @JsonProperty(value = "billing-contact")
    private Contact billingContact;

    @JsonApiRelation
    @JsonProperty(value = "subscription-plan")
    private SubscriptionPlan subscriptionPlan;

    @JsonApiRelation
    @JsonProperty(value = "account-manager")
    private User accountManager;

    @JsonApiRelation
    @JsonProperty(value = "owner")
    private User owner;

    @JsonApiRelation
    @JsonProperty(value = "sales-support")
    private User salesSupport;

    @JsonApiRelation
    @JsonProperty(value = "company")
    private Company company;

    @JsonApiRelation
    @JsonProperty(value = "meal-plan")
    private MealPlan mealPlan;

    @JsonApiRelation
    @JsonProperty(value = "preference-profile")
    private MealPlanningPreferenceProfile preferenceProfile;

    @JsonApiRelation
    @JsonProperty(value = "tax-rate")
    private InvoicingTaxRate taxRate;

    @JsonApiRelation
    @JsonProperty(value = "giftbit-card")
    private GiftbitCard giftbitCard;

    @JsonApiRelation
    @JsonProperty(value = "wallet")
    private CurrenciesWallet wallet;

    @JsonApiRelation
    @JsonProperty(value = "areas")
    private List<Area> areas;

    @JsonApiRelation
    @JsonProperty(value = "delivery-locations")
    private List<DeliveryLocation> deliveryLocations;

    @JsonApiRelation
    @JsonProperty(value = "payment-cards")
    private List<PaymentCard> paymentCards;

    @JsonApiRelation
    @JsonProperty(value = "admin-contacts")
    private List<Contact> adminContacts;

    @JsonApiRelation
    @JsonProperty(value = "admins")
    private List<User> admins;

    @JsonApiRelation
    @JsonProperty(value = "order-contacts")
    private List<Contact> orderContacts;

    @JsonApiRelation
    @JsonProperty(value = "orders")
    private List<Order> orders;

    @JsonApiRelation
    @JsonProperty(value = "contacts")
    private List<Contact> contacts;

    @JsonApiRelation
    @JsonProperty(value = "teams")
    private List<Team> teams;

    @JsonApiRelation
    @JsonProperty(value = "all-client-versions")
    private List<HistorianVersion> allClientVersions;

    @JsonApiRelation
    @JsonProperty(value = "versions")
    private List<HistorianVersion> versions;

    @JsonApiRelation
    @JsonProperty(value = "meal-planning-templates")
    private List<MealPlanningTemplate> mealPlanningTemplates;

    @JsonApiRelation
    @JsonProperty(value = "meal-planning-instances")
    private List<MealPlanningInstance> mealPlanningInstances;

    @JsonApiRelation
    @JsonProperty(value = "meal-planning-reservations")
    private List<MealPlanningReservation> mealPlanningReservations;

    @JsonApiRelation
    @JsonProperty(value = "client-discounts")
    private List<ClientDiscount> clientDiscounts;

    @JsonApiRelation
    @JsonProperty(value = "giftbit-gifts")
    private List<GiftbitGift> giftbitGifts;

    @JsonApiRelation
    @JsonProperty(value = "giftbit-errors")
    private List<GiftbitError> giftbitErrors;
}
