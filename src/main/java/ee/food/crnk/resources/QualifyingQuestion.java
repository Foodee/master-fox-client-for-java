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

@JsonApiResource(type = "qualifying-questions")
@Data
public class QualifyingQuestion {

    public static QualifyingQuestion id(Long id) {
        val r = new QualifyingQuestion();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    
    @JsonProperty(value = "contact-person")
    private String contactPerson;

    
    @JsonProperty(value = "order-frequency")
    private String orderFrequency;

    
    @JsonProperty(value = "order-size")
    private String orderSize;

    
    @JsonProperty(value = "order-budget")
    private String orderBudget;

    /********************************************
     * Relationships
     ********************************************/
}
