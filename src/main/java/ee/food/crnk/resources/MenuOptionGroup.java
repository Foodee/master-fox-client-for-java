package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "menu-option-groups")
@Data
public class MenuOptionGroup {

    public static MenuOptionGroup id(Long id) {
        val r = new MenuOptionGroup();
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

    
    @JsonProperty(value = "verb")
    private String verb;

    
    @JsonProperty(value = "is-required")
    private Boolean isRequired;

    
    @JsonProperty(value = "is-single-opt")
    private Boolean isSingleOpt;

    
    @JsonProperty(value = "is-packaged-separately")
    private Boolean isPackagedSeparately;

    
    @JsonProperty(value = "position")
    private Integer position;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "menu-item")
    private MenuItem menuItem;

    @JsonApiRelation
    @JsonProperty(value = "menu-option-items")
    private List<MenuOptionItem> menuOptionItems;
}
