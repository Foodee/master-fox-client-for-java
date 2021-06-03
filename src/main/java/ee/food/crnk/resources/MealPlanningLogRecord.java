package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "meal-planning-log-records")
@Data
public class MealPlanningLogRecord {

    public static MealPlanningLogRecord id(Long id) {
        val r = new MealPlanningLogRecord();
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

    @JsonProperty(value = "text")
    private String text;

    @JsonProperty(value = "solver-log")
    private Object solverLog;

    @JsonProperty(value = "foodee-employee")
    private Boolean foodeeEmployee;

    /********************************************
     * Relationships
     ********************************************/
}
