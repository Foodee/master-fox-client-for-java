package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class PickupLocationPathSpec extends ResourcePathSpec {
 public static PickupLocationPathSpec pickupLocationPathSpec = new PickupLocationPathSpec();

 public PickupLocationPathSpec() {
  super(PathSpec.empty());
 }

 public PickupLocationPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected PickupLocationPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected PickupLocationPathSpec bindSpec(AbstractPathSpec spec) {
  return new PickupLocationPathSpec(spec);
 }
}
