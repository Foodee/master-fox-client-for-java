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

@JsonApiResource(type = "orders")
@Data
public class Order {

    public static Order id(Long id) {
        val r = new Order();
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

    
    @JsonProperty(value = "allows-guests")
    private Boolean allowsGuests;

    
    @JsonProperty(value = "allows-pay-out-of-pocket")
    private Boolean allowsPayOutOfPocket;

    
    @JsonProperty(value = "bowtie-service-fee")
    private Double bowtieServiceFee;

    
    @JsonProperty(value = "created-at")
    private Date createdAt;

    
    @JsonProperty(value = "deadline-at")
    private Date deadlineAt;

    
    @JsonProperty(value = "deliver-at")
    private Date deliverAt;

    
    @JsonProperty(value = "deliver-on")
    private Date deliverOn;

    
    @JsonProperty(value = "delivered-at")
    private Date deliveredAt;

    
    @JsonProperty(value = "expires-at")
    private Date expiresAt;

    
    @JsonProperty(value = "opens-at")
    private Date opensAt;

    
    @JsonProperty(value = "flag")
    private Boolean flag;

    
    @JsonProperty(value = "guest-list")
    private List<Object> guestList;

    
    @JsonProperty(value = "budget-type")
    private String budgetType;

    
    @JsonProperty(value = "duplicated-from-id")
    private Integer duplicatedFromId;

    
    @JsonProperty(value = "ignores-capacity-limit")
    private Boolean ignoresCapacityLimit;

    
    @JsonProperty(value = "is-foodhall")
    private Boolean isFoodhall;

    
    @JsonProperty(value = "is-same-day")
    private Boolean isSameDay;

    
    @JsonProperty(value = "valid-members-count")
    private Integer validMembersCount;

    
    @JsonProperty(value = "name")
    private String name;

    
    @JsonProperty(value = "order-type")
    private String orderType;

    
    @JsonProperty(value = "monitoring-notes")
    private Object monitoringNotes;

    
    @JsonProperty(value = "notes")
    private Object notes;

    
    @JsonProperty(value = "order-images")
    private List<String> orderImages;

    
    @JsonProperty(value = "number-of-people")
    private Integer numberOfPeople;

    
    @JsonProperty(value = "pay-out-of-pocket-fee")
    private Double payOutOfPocketFee;

    
    @JsonProperty(value = "per-person-budget")
    private Float perPersonBudget;

    
    @JsonProperty(value = "picked-up-at")
    private Date pickedUpAt;

    
    @JsonProperty(value = "pickup-at")
    private Date pickupAt;

    
    @JsonProperty(value = "set-menu")
    private Object setMenu;

    
    @JsonProperty(value = "state")
    private String state;

    
    @JsonProperty(value = "updated-at")
    private Date updatedAt;

    
    @JsonProperty(value = "client-location-id")
    private Integer clientLocationId;

    
    @JsonProperty(value = "restaurant-poll-deadline-at")
    private Date restaurantPollDeadlineAt;

    
    @JsonProperty(value = "is-autosave")
    private Boolean isAutosave;

    
    @JsonProperty(value = "large-order")
    private Boolean largeOrder;

    
    @JsonProperty(value = "outside-hours")
    private Boolean outsideHours;

    
    @JsonProperty(value = "out-of-zone")
    private Boolean outOfZone;

    
    @JsonProperty(value = "is-meal-plan-order")
    private Boolean isMealPlanOrder;

    
    @JsonProperty(value = "orders-in-tranche")
    private Integer ordersInTranche;

    
    @JsonProperty(value = "tranche")
    private String tranche;

    
    @JsonProperty(value = "client-confirmation-id")
    private UUID clientConfirmationId;

    
    @JsonProperty(value = "restaurant-confirmation-id")
    private UUID restaurantConfirmationId;

    
    @JsonProperty(value = "third-party-logistics-exception")
    private String thirdPartyLogisticsException;

    
    @JsonProperty(value = "is-bookmark")
    private Boolean isBookmark;

    
    @JsonProperty(value = "bookmark-expires-at")
    private Date bookmarkExpiresAt;

    
    @JsonProperty(value = "bookmark-name")
    private String bookmarkName;

    
    @JsonProperty(value = "url-safe-id")
    private String urlSafeId;

    
    @JsonProperty(value = "uuid")
    private UUID uuid;

    
    @JsonProperty(value = "online")
    private Boolean online;

    
    @JsonProperty(value = "cutlery-preference")
    private String cutleryPreference;

    
    @JsonProperty(value = "waive-delivery-fee")
    private Boolean waiveDeliveryFee;

    
    @JsonProperty(value = "waive-service-fee")
    private Boolean waiveServiceFee;

    
    @JsonProperty(value = "ordered-count")
    private Integer orderedCount;

    
    @JsonProperty(value = "member-count")
    private Integer memberCount;

    
    @JsonProperty(value = "is-template")
    private Boolean isTemplate;

    
    @JsonProperty(value = "state-event")
    private String stateEvent;

    @JsonIgnore
    @JsonProperty(value = "max-number-of-people")
    private Integer maxNumberOfPeople;

    @JsonIgnore
    @JsonProperty(value = "total-amount")
    private Double totalAmount;

    @JsonIgnore
    @JsonProperty(value = "restaurant-total-amount")
    private Double restaurantTotalAmount;

    
    @JsonProperty(value = "delivery-estimate")
    private Object deliveryEstimate;

    
    @JsonProperty(value = "override-pickup-at-adjustment")
    private Boolean overridePickupAtAdjustment;

    
    @JsonProperty(value = "logistics-type")
    private Integer logisticsType;

    
    @JsonProperty(value = "third-party-logistics-id")
    private String thirdPartyLogisticsId;

    
    @JsonProperty(value = "third-party-logistics-tracking-url")
    private String thirdPartyLogisticsTrackingUrl;

    
    @JsonProperty(value = "synced-with-third-party-logistics-at")
    private Date syncedWithThirdPartyLogisticsAt;

    
    @JsonProperty(value = "waive-delivery-fee-accounting-code")
    private String waiveDeliveryFeeAccountingCode;

    
    @JsonProperty(value = "waive-service-fee-accounting-code")
    private String waiveServiceFeeAccountingCode;

    
    @JsonProperty(value = "waive-delivery-fee-description")
    private String waiveDeliveryFeeDescription;

    
    @JsonProperty(value = "waive-service-fee-description")
    private String waiveServiceFeeDescription;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "area")
    private Area area;

    @JsonApiRelation
    @JsonProperty(value = "owner")
    private User owner;

    @JsonApiRelation
    @JsonProperty(value = "creator")
    private User creator;

    @JsonApiRelation
    @JsonProperty(value = "payment-card")
    private PaymentCard paymentCard;

    @JsonApiRelation
    @JsonProperty(value = "contact")
    private Contact contact;

    @JsonApiRelation
    @JsonProperty(value = "client")
    private Client client;

    @JsonApiRelation
    @JsonProperty(value = "restaurant")
    private Restaurant restaurant;

    @JsonApiRelation
    @JsonProperty(value = "courier")
    private Courier courier;

    @JsonApiRelation
    @JsonProperty(value = "promo-code")
    private PromoCode promoCode;

    @JsonApiRelation
    @JsonProperty(value = "driver")
    private User driver;

    @JsonApiRelation
    @JsonProperty(value = "sales-support")
    private User salesSupport;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-location")
    private Location restaurantLocation;

    @JsonApiRelation
    @JsonProperty(value = "client-location")
    private Location clientLocation;

    @JsonApiRelation
    @JsonProperty(value = "menu")
    private Menu menu;

    @JsonApiRelation
    @JsonProperty(value = "menu-filter")
    private MealPlanningRequirement menuFilter;

    @JsonApiRelation
    @JsonProperty(value = "custom-location")
    private Location customLocation;

    @JsonApiRelation
    @JsonProperty(value = "giftbit-error")
    private GiftbitError giftbitError;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-invoice")
    private InvoicingLedgerItem restaurantInvoice;

    @JsonApiRelation
    @JsonProperty(value = "client-invoice")
    private InvoicingLedgerItem clientInvoice;

    @JsonApiRelation
    @JsonProperty(value = "invoice")
    private AccountingLedgerItem invoice;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-bill")
    private AccountingLedgerItem restaurantBill;

    @JsonApiRelation
    @JsonProperty(value = "client-order-invoice")
    private ClientOrderInvoice clientOrderInvoice;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-order-invoice")
    private RestaurantOrderInvoice restaurantOrderInvoice;

    @JsonApiRelation
    @JsonProperty(value = "arrival-estimate")
    private LogisticsArrivalEstimate arrivalEstimate;

    @JsonApiRelation
    @JsonProperty(value = "client-discounts")
    private List<ClientDiscount> clientDiscounts;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-discounts")
    private List<RestaurantDiscount> restaurantDiscounts;

    @JsonApiRelation
    @JsonProperty(value = "email-messages")
    private List<EmailMessage> emailMessages;

    @JsonApiRelation
    @JsonProperty(value = "delivery-cases")
    private List<DeliveryCase> deliveryCases;

    @JsonApiRelation
    @JsonProperty(value = "desk-cases")
    private List<DeskCase> deskCases;

    @JsonApiRelation
    @JsonProperty(value = "all-order-versions")
    private List<HistorianVersion> allOrderVersions;

    @JsonApiRelation
    @JsonProperty(value = "versions")
    private List<HistorianVersion> versions;

    @JsonApiRelation
    @JsonProperty(value = "pollable-restaurants")
    private List<Restaurant> pollableRestaurants;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-votes")
    private List<RestaurantVote> restaurantVotes;

    @JsonApiRelation
    @JsonProperty(value = "teams")
    private List<Team> teams;

    @JsonApiRelation
    @JsonProperty(value = "all-users")
    private List<User> allUsers;

    @JsonApiRelation
    @JsonProperty(value = "ordered-users")
    private List<User> orderedUsers;

    @JsonApiRelation
    @JsonProperty(value = "ordered-group-order-members")
    private List<GroupOrderMember> orderedGroupOrderMembers;

    @JsonApiRelation
    @JsonProperty(value = "joined-users")
    private List<User> joinedUsers;

    @JsonApiRelation
    @JsonProperty(value = "team-members")
    private List<User> teamMembers;

    @JsonApiRelation
    @JsonProperty(value = "group-order-members")
    private List<GroupOrderMember> groupOrderMembers;

    @JsonApiRelation
    @JsonProperty(value = "order-items")
    private List<OrderItem> orderItems;

    @JsonApiRelation
    @JsonProperty(value = "ledger-items")
    private List<AccountingLedgerItem> ledgerItems;

    @JsonApiRelation
    @JsonProperty(value = "salesforce-cases")
    private List<SalesforceCase> salesforceCases;

    @JsonApiRelation
    @JsonProperty(value = "notification-logs")
    private List<NotificationLog> notificationLogs;
}
