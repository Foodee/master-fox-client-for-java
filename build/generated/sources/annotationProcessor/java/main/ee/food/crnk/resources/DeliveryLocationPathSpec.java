package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class DeliveryLocationPathSpec extends ResourcePathSpec {
 public static DeliveryLocationPathSpec deliveryLocationPathSpec = new DeliveryLocationPathSpec();

 public DeliveryLocationPathSpec() {
  super(PathSpec.empty());
 }

 public DeliveryLocationPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected DeliveryLocationPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected DeliveryLocationPathSpec bindSpec(AbstractPathSpec spec) {
  return new DeliveryLocationPathSpec(spec);
 }
}
