package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "restaurant-rankings")
@Data
public class RestaurantRanking {

    public static RestaurantRanking id(Long id) {
        val r = new RestaurantRanking();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "month")
    private Object month;

    
    @JsonProperty(value = "orders")
    private Integer orders;

    
    @JsonProperty(value = "order-platform-rank")
    private Integer orderPlatformRank;

    
    @JsonProperty(value = "order-area-rank")
    private Integer orderAreaRank;

    
    @JsonProperty(value = "order-area-percent-rank")
    private Float orderAreaPercentRank;

    
    @JsonProperty(value = "area-restaurant-count")
    private Integer areaRestaurantCount;

    
    @JsonProperty(value = "platform-restaurant-count")
    private Integer platformRestaurantCount;

    
    @JsonProperty(value = "order-total")
    private Double orderTotal;

    
    @JsonProperty(value = "order-percentage")
    private Double orderPercentage;

    
    @JsonProperty(value = "online-orders")
    private Integer onlineOrders;

    
    @JsonProperty(value = "online-total")
    private Double onlineTotal;

    
    @JsonProperty(value = "online-platform-rank")
    private Integer onlinePlatformRank;

    
    @JsonProperty(value = "online-area-rank")
    private Integer onlineAreaRank;

    
    @JsonProperty(value = "online-area-percent-rank")
    private Float onlineAreaPercentRank;

    
    @JsonProperty(value = "online-percentage")
    private Double onlinePercentage;

    
    @JsonProperty(value = "foodee-orders")
    private Integer foodeeOrders;

    
    @JsonProperty(value = "foodee-total")
    private Double foodeeTotal;

    
    @JsonProperty(value = "foodee-platform-rank")
    private Integer foodeePlatformRank;

    
    @JsonProperty(value = "foodee-area-rank")
    private Integer foodeeAreaRank;

    
    @JsonProperty(value = "foodee-area-percent-rank")
    private Float foodeeAreaPercentRank;

    
    @JsonProperty(value = "foodee-percentage")
    private Double foodeePercentage;

    
    @JsonProperty(value = "online-team-orders")
    private Integer onlineTeamOrders;

    
    @JsonProperty(value = "online-team-order-total")
    private Double onlineTeamOrderTotal;

    
    @JsonProperty(value = "online-team-order-platform-rank")
    private Integer onlineTeamOrderPlatformRank;

    
    @JsonProperty(value = "online-team-order-area-rank")
    private Integer onlineTeamOrderAreaRank;

    
    @JsonProperty(value = "online-team-order-area-percent-rank")
    private Float onlineTeamOrderAreaPercentRank;

    
    @JsonProperty(value = "online-team-order-percentage")
    private Double onlineTeamOrderPercentage;

    
    @JsonProperty(value = "foodee-team-orders")
    private Integer foodeeTeamOrders;

    
    @JsonProperty(value = "foodee-team-order-total")
    private Double foodeeTeamOrderTotal;

    
    @JsonProperty(value = "foodee-team-order-platform-rank")
    private Integer foodeeTeamOrderPlatformRank;

    
    @JsonProperty(value = "foodee-team-order-area-rank")
    private Integer foodeeTeamOrderAreaRank;

    
    @JsonProperty(value = "foodee-team-order-area-percent-rank")
    private Float foodeeTeamOrderAreaPercentRank;

    
    @JsonProperty(value = "foodee-team-order-percentage")
    private Double foodeeTeamOrderPercentage;

    
    @JsonProperty(value = "online-enterprise-orders")
    private Integer onlineEnterpriseOrders;

    
    @JsonProperty(value = "online-enterprise-order-total")
    private Double onlineEnterpriseOrderTotal;

    
    @JsonProperty(value = "online-enterprise-order-platform-rank")
    private Integer onlineEnterpriseOrderPlatformRank;

    
    @JsonProperty(value = "online-enterprise-order-area-rank")
    private Integer onlineEnterpriseOrderAreaRank;

    
    @JsonProperty(value = "online-enterprise-order-area-percent-rank")
    private Float onlineEnterpriseOrderAreaPercentRank;

    
    @JsonProperty(value = "online-enterprise-order-percentage")
    private Double onlineEnterpriseOrderPercentage;

    
    @JsonProperty(value = "foodee-enterprise-orders")
    private Integer foodeeEnterpriseOrders;

    
    @JsonProperty(value = "foodee-enterprise-order-total")
    private Double foodeeEnterpriseOrderTotal;

    
    @JsonProperty(value = "foodee-enterprise-order-platform-rank")
    private Integer foodeeEnterpriseOrderPlatformRank;

    
    @JsonProperty(value = "foodee-enterprise-order-area-rank")
    private Integer foodeeEnterpriseOrderAreaRank;

    
    @JsonProperty(value = "foodee-enterprise-order-area-percent-rank")
    private Float foodeeEnterpriseOrderAreaPercentRank;

    
    @JsonProperty(value = "foodee-enterprise-order-percentage")
    private Double foodeeEnterpriseOrderPercentage;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "restaurant")
    private Restaurant restaurant;
}
