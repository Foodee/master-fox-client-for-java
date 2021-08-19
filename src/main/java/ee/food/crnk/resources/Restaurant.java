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

@JsonApiResource(type = "restaurants")
@Data
public class Restaurant {

    public static Restaurant id(Long id) {
        val r = new Restaurant();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "pickup-notes")
    private Object pickupNotes;

    
    @JsonProperty(value = "enterprise-request")
    private String enterpriseRequest;

    
    @JsonProperty(value = "is-paying-admin-fee")
    private Boolean isPayingAdminFee;

    
    @JsonProperty(value = "receives-daily-order-summary")
    private Boolean receivesDailyOrderSummary;

    
    @JsonProperty(value = "receives-sms")
    private Boolean receivesSMS;

    
    @JsonProperty(value = "uuid")
    private UUID uuid;

    
    @JsonProperty(value = "xero-contact-id")
    private UUID xeroContactId;

    
    @JsonProperty(value = "xero-synchronized-at")
    private Date xeroSynchronizedAt;

    
    @JsonProperty(value = "created-at")
    private Date createdAt;

    
    @JsonProperty(value = "updated-at")
    private Date updatedAt;

    
    @JsonProperty(value = "active")
    private Boolean active;

    
    @JsonProperty(value = "internal")
    private Boolean internal;

    
    @JsonProperty(value = "is-exclusive")
    private Boolean isExclusive;

    
    @JsonProperty(value = "can-group-order")
    private Boolean canGroupOrder;

    
    @JsonProperty(value = "can-same-day-order")
    private Boolean canSameDayOrder;

    
    @JsonProperty(value = "can-same-day-team-order")
    private Boolean canSameDayTeamOrder;

    
    @JsonProperty(value = "can-enterprise-order")
    private Boolean canEnterpriseOrder;

    
    @JsonProperty(value = "can-same-day-enterprise-order")
    private Boolean canSameDayEnterpriseOrder;

    
    @JsonProperty(value = "same-day-hours-in-advance")
    private Float sameDayHoursInAdvance;

    
    @JsonProperty(value = "hours-in-advance")
    private Float hoursInAdvance;

    
    @JsonProperty(value = "enterprise-hours-in-advance")
    private Float enterpriseHoursInAdvance;

    
    @JsonProperty(value = "minimum-order")
    private Integer minimumOrder;

    
    @JsonProperty(value = "name")
    private String name;

    
    @JsonProperty(value = "legal-name")
    private String legalName;

    
    @JsonProperty(value = "dietary-tags-counts")
    private Object dietaryTagsCounts;

    
    @JsonProperty(value = "slug")
    private String slug;

    
    @JsonProperty(value = "subtitle")
    private String subtitle;

    
    @JsonProperty(value = "thumbnail-image-url")
    private String thumbnailImageUrl;

    
    @JsonProperty(value = "cover-image-url")
    private String coverImageUrl;

    
    @JsonProperty(value = "marketing-title")
    private String marketingTitle;

    
    @JsonProperty(value = "marketing-description")
    private String marketingDescription;

    
    @JsonProperty(value = "coming-soon")
    private Boolean comingSoon;

    
    @JsonProperty(value = "counts")
    private Object counts;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "billing-location")
    private Location billingLocation;

    @JsonApiRelation
    @JsonProperty(value = "billing-contact")
    private Contact billingContact;

    @JsonApiRelation
    @JsonProperty(value = "owner")
    private User owner;

    @JsonApiRelation
    @JsonProperty(value = "active-menu")
    private Menu activeMenu;

    @JsonApiRelation
    @JsonProperty(value = "admins")
    private List<User> admins;

    @JsonApiRelation
    @JsonProperty(value = "admin-contacts")
    private List<Contact> adminContacts;

    @JsonApiRelation
    @JsonProperty(value = "all-restaurant-versions")
    private List<HistorianVersion> allRestaurantVersions;

    @JsonApiRelation
    @JsonProperty(value = "versions")
    private List<HistorianVersion> versions;

    @JsonApiRelation
    @JsonProperty(value = "promo-codes")
    private List<PromoCode> promoCodes;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-constraints")
    private List<MealPlanningRestaurantConstraint> restaurantConstraints;

    @JsonApiRelation
    @JsonProperty(value = "rankings")
    private List<RestaurantRanking> rankings;

    @JsonApiRelation
    @JsonProperty(value = "orders")
    private List<Order> orders;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-capacity-tranches")
    private List<RestaurantCapacityTranche> restaurantCapacityTranches;

    @JsonApiRelation
    @JsonProperty(value = "service-times")
    private List<ServiceTime> serviceTimes;

    @JsonApiRelation
    @JsonProperty(value = "pickup-locations")
    private List<PickupLocation> pickupLocations;

    @JsonApiRelation
    @JsonProperty(value = "dietary-tags")
    private List<DietaryTag> dietaryTags;

    @JsonApiRelation
    @JsonProperty(value = "food-types")
    private List<FoodType> foodTypes;

    @JsonApiRelation
    @JsonProperty(value = "meal-types")
    private List<MealType> mealTypes;

    @JsonApiRelation
    @JsonProperty(value = "tags")
    private List<Tag> tags;

    @JsonApiRelation
    @JsonProperty(value = "areas")
    private List<Area> areas;

    @JsonApiRelation
    @JsonProperty(value = "menus")
    private List<Menu> menus;

    @JsonApiRelation
    @JsonProperty(value = "restaurant-votes")
    private List<RestaurantVote> restaurantVotes;

    @JsonApiRelation
    @JsonProperty(value = "closures")
    private List<RestaurantClosure> closures;
}
