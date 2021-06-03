package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "events")
@Data
public class Event {

    public static Event id(Long id) {
        val r = new Event();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    /********************************************
     * Relationships
     ********************************************/
}
