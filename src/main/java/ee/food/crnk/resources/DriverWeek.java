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

@JsonApiResource(type = "driver-weeks")
@Data
public class DriverWeek {

    public static DriverWeek id(Long id) {
        val r = new DriverWeek();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "created-at")
    private Date createdAt;

    
    @JsonProperty(value = "updated-at")
    private Date updatedAt;

    
    @JsonProperty(value = "monday")
    private Date monday;

    
    @JsonProperty(value = "notes")
    private Object notes;

    
    @JsonProperty(value = "available-monday-breakfast")
    private Boolean availableMondayBreakfast;

    
    @JsonProperty(value = "available-monday-lunch")
    private Boolean availableMondayLunch;

    
    @JsonProperty(value = "available-monday-dinner")
    private Boolean availableMondayDinner;

    
    @JsonProperty(value = "available-tuesday-breakfast")
    private Boolean availableTuesdayBreakfast;

    
    @JsonProperty(value = "available-tuesday-lunch")
    private Boolean availableTuesdayLunch;

    
    @JsonProperty(value = "available-tuesday-dinner")
    private Boolean availableTuesdayDinner;

    
    @JsonProperty(value = "available-wednesday-breakfast")
    private Boolean availableWednesdayBreakfast;

    
    @JsonProperty(value = "available-wednesday-lunch")
    private Boolean availableWednesdayLunch;

    
    @JsonProperty(value = "available-wednesday-dinner")
    private Boolean availableWednesdayDinner;

    
    @JsonProperty(value = "available-thursday-breakfast")
    private Boolean availableThursdayBreakfast;

    
    @JsonProperty(value = "available-thursday-lunch")
    private Boolean availableThursdayLunch;

    
    @JsonProperty(value = "available-thursday-dinner")
    private Boolean availableThursdayDinner;

    
    @JsonProperty(value = "available-friday-breakfast")
    private Boolean availableFridayBreakfast;

    
    @JsonProperty(value = "available-friday-lunch")
    private Boolean availableFridayLunch;

    
    @JsonProperty(value = "available-friday-dinner")
    private Boolean availableFridayDinner;

    
    @JsonProperty(value = "available-saturday-breakfast")
    private Boolean availableSaturdayBreakfast;

    
    @JsonProperty(value = "available-saturday-lunch")
    private Boolean availableSaturdayLunch;

    
    @JsonProperty(value = "available-saturday-dinner")
    private Boolean availableSaturdayDinner;

    
    @JsonProperty(value = "available-sunday-breakfast")
    private Boolean availableSundayBreakfast;

    
    @JsonProperty(value = "available-sunday-lunch")
    private Boolean availableSundayLunch;

    
    @JsonProperty(value = "available-sunday-dinner")
    private Boolean availableSundayDinner;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "driver")
    private User driver;
}
