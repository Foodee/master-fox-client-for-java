package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class DeliveryCasePathSpec extends ResourcePathSpec {
 public static DeliveryCasePathSpec deliveryCasePathSpec = new DeliveryCasePathSpec();

 public DeliveryCasePathSpec() {
  super(PathSpec.empty());
 }

 public DeliveryCasePathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected DeliveryCasePathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected DeliveryCasePathSpec bindSpec(AbstractPathSpec spec) {
  return new DeliveryCasePathSpec(spec);
 }
}
