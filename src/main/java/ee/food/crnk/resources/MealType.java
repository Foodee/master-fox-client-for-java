package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "meal-types")
@Data
public class MealType {

    public static MealType id(Long id) {
        val r = new MealType();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "emoji")
    private String emoji;

    
    @JsonProperty(value = "name")
    private String name;

    
    @JsonProperty(value = "is-exclusive")
    private Boolean isExclusive;

    /********************************************
     * Relationships
     ********************************************/
}
