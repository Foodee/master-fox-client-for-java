package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "users")
@Data
public class User {

    public static User id(Long id) {
        val r = new User();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "accepted-terms-at")
    private Date acceptedTermsAt;

    
    @JsonProperty(value = "last-sign-in-at")
    private Date lastSignInAt;

    
    @JsonProperty(value = "slack-channel-info")
    private Object slackChannelInfo;

    
    @JsonProperty(value = "on-payroll")
    private Boolean onPayroll;

    
    @JsonProperty(value = "client-always-call")
    private Boolean clientAlwaysCall;

    
    @JsonProperty(value = "active")
    private Boolean active;

    
    @JsonProperty(value = "managed-internally")
    private Boolean managedInternally;

    
    @JsonProperty(value = "department")
    private String department;

    
    @JsonProperty(value = "email")
    private String email;

    
    @JsonProperty(value = "salesforce-email")
    private String salesforceEmail;

    
    @JsonProperty(value = "profile-picture-url")
    private String profilePictureUrl;

    
    @JsonProperty(value = "reset-password-token")
    private String resetPasswordToken;

    
    @JsonProperty(value = "override-phone-number")
    private Boolean overridePhoneNumber;

    
    @JsonProperty(value = "notify-by-email-on-delivery")
    private Boolean notifyByEmailOnDelivery;

    
    @JsonProperty(value = "notify-by-sms-on-delivery")
    private Boolean notifyBySMSOnDelivery;

    
    @JsonProperty(value = "notification-preferences")
    private Object notificationPreferences;

    
    @JsonProperty(value = "invitation-sent-at")
    private Date invitationSentAt;

    
    @JsonProperty(value = "invitation-token")
    private String invitationToken;

    
    @JsonProperty(value = "invitation-accepted-at")
    private Date invitationAcceptedAt;

    
    @JsonProperty(value = "driver-device-info")
    private Object driverDeviceInfo;

    
    @JsonProperty(value = "driver-file-number")
    private String driverFileNumber;

    
    @JsonProperty(value = "driver-speed-rating")
    private Integer driverSpeedRating;

    
    @JsonProperty(value = "driver-vehicle-type")
    private String driverVehicleType;

    
    @JsonProperty(value = "last-driver-notification-sent-at")
    private Date lastDriverNotificationSentAt;

    
    @JsonProperty(value = "is-active-driver")
    private Boolean isActiveDriver;

    
    @JsonProperty(value = "created-at")
    private Date createdAt;

    
    @JsonProperty(value = "custom-fields")
    private Object customFields;

    
    @JsonProperty(value = "storage")
    private Object storage;

    
    @JsonProperty(value = "state")
    private String state;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "client")
    private Client client;

    @JsonApiRelation
    @JsonProperty(value = "communication-preference")
    private CommunicationPreference communicationPreference;

    @JsonApiRelation
    @JsonProperty(value = "preference-profile")
    private MealPlanningPreferenceProfile preferenceProfile;

    @JsonApiRelation
    @JsonProperty(value = "driver-pings")
    private List<DriverPing> driverPings;

    @JsonApiRelation
    @JsonProperty(value = "driver-weeks")
    private List<DriverWeek> driverWeeks;

    @JsonApiRelation
    @JsonProperty(value = "driver-days")
    private List<DriverDay> driverDays;

    @JsonApiRelation
    @JsonProperty(value = "delivered-orders")
    private List<Order> deliveredOrders;

    @JsonApiRelation
    @JsonProperty(value = "couriers")
    private List<Courier> couriers;

    @JsonApiRelation
    @JsonProperty(value = "clients")
    private List<Client> clients;

    @JsonApiRelation
    @JsonProperty(value = "areas")
    private List<Area> areas;

    @JsonApiRelation
    @JsonProperty(value = "roles")
    private List<Role> roles;

    @JsonApiRelation
    @JsonProperty(value = "payment-cards")
    private List<PaymentCard> paymentCards;

    @JsonApiRelation
    @JsonProperty(value = "teams")
    private List<Team> teams;

    @JsonApiRelation
    @JsonProperty(value = "all-user-versions")
    private List<HistorianVersion> allUserVersions;

    @JsonApiRelation
    @JsonProperty(value = "versions")
    private List<HistorianVersion> versions;

    @JsonApiRelation
    @JsonProperty(value = "client-orders")
    private List<Order> clientOrders;

    @JsonApiRelation
    @JsonProperty(value = "events")
    private List<MealPlanningEvent> events;
}
