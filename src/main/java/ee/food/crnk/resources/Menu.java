package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "menus")
@Data
public class Menu {

    public static Menu id(Long id) {
        val r = new Menu();
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

    @JsonProperty(value = "active")
    private Boolean active;

    @JsonProperty(value = "area-id")
    private Integer areaId;

    @JsonProperty(value = "restaurant-id")
    private Integer restaurantId;

    @JsonProperty(value = "created-at")
    private Date createdAt;

    @JsonProperty(value = "dietary-tags-counts")
    private Object dietaryTagsCounts;

    @JsonProperty(value = "set-menus")
    private Object setMenus;

    @JsonProperty(value = "draft")
    private Boolean draft;

    @JsonProperty(value = "ancestry")
    private String ancestry;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "area")
    private Area area;

    @JsonApiRelation
    @JsonProperty(value = "restaurant")
    private Restaurant restaurant;

    @JsonApiRelation
    @JsonProperty(value = "menu-groups")
    private List<MenuGroup> menuGroups;

    @JsonApiRelation
    @JsonProperty(value = "menu-items")
    private List<MenuItem> menuItems;

    @JsonApiRelation
    @JsonProperty(value = "dietary-tags")
    private List<DietaryTag> dietaryTags;

    @JsonApiRelation
    @JsonProperty(value = "orders")
    private List<Order> orders;
}
