package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "roles")
@Data
public class Role {

    public static Role id(Long id) {
        val r = new Role();
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

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "user")
    private User user;
}
