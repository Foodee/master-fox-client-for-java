package ee.food.crnk.resources;

import io.crnk.core.queryspec.internal.typed.TypedQuerySpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class CourierQuerySpec extends TypedQuerySpec<Courier, CourierPathSpec> {
 public CourierQuerySpec() {
  super(ee.food.crnk.resources.Courier.class, new CourierPathSpec());
 }
}
