package ee.food.crnk.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.val;

import java.util.*;

@JsonApiResource(type = "locations")
@Data
public class Location {

    public static Location id(Long id) {
        val r = new Location();
        r.setId(id);
        return r;
    }

    @JsonApiId
    private Long id;

    /********************************************
     * Attributes
     ********************************************/

    @JsonProperty(value = "latitude")
    private Double latitude;

    @JsonProperty(value = "longitude")
    private Double longitude;

    @JsonProperty(value = "buzzer")
    private String buzzer;

    @JsonProperty(value = "unit-number")
    private String unitNumber;

    @JsonProperty(value = "floor")
    private String floor;

    @JsonProperty(value = "building")
    private String building;

    @JsonProperty(value = "city")
    private String city;

    @JsonProperty(value = "country")
    private String country;

    @JsonProperty(value = "province")
    private String province;

    @JsonProperty(value = "street")
    private String street;

    @JsonProperty(value = "address-code")
    private String addressCode;

    @JsonProperty(value = "default")
    private Boolean isDefault;

    @JsonProperty(value = "address-line-1")
    private String addressLine1;

    @JsonProperty(value = "address-line-2")
    private String addressLine2;

    @JsonProperty(value = "raw-address")
    private String rawAddress;

    /********************************************
     * Relationships
     ********************************************/

    @JsonApiRelation
    @JsonProperty(value = "area")
    private Area area;
}
