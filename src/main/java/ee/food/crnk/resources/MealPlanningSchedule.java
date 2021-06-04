package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "meal-planning-schedules")
@Data
public class MealPlanningSchedule {

    public static MealPlanningSchedule id(Long id) {
        val r = new MealPlanningSchedule();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "frequency")
    private String frequency;

    
    @JsonProperty(value = "frequency-value")
    private List<Integer> frequencyValue;

    
    @JsonProperty(value = "periods-in-advance")
    private Integer periodsInAdvance;

    
    @JsonProperty(value = "periods-per-schedule")
    private Integer periodsPerSchedule;

    
    @JsonProperty(value = "starts-on")
    private Date startsOn;

    
    @JsonProperty(value = "ends-on")
    private Date endsOn;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "template")
    private MealPlanningTemplate template;
}
