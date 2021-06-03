package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "dietary-tags")
@Data
public class DietaryTag {

    public static DietaryTag id(Long id) {
        val r = new DietaryTag();
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

    @JsonProperty(value = "slug")
    private String slug;

    @JsonProperty(value = "abbreviation")
    private String abbreviation;

    @JsonProperty(value = "color")
    private String color;

    @JsonProperty(value = "tag-type")
    private String tagType;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "menu-option-items")
    private List<MenuOptionItem> menuOptionItems;
}
