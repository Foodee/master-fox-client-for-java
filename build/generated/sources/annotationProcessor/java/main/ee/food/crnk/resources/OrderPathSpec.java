package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class OrderPathSpec extends ResourcePathSpec {
 public static OrderPathSpec orderPathSpec = new OrderPathSpec();

 public OrderPathSpec() {
  super(PathSpec.empty());
 }

 public OrderPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected OrderPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected OrderPathSpec bindSpec(AbstractPathSpec spec) {
  return new OrderPathSpec(spec);
 }
}
