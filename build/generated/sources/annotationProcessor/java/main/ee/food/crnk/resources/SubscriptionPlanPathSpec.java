package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class SubscriptionPlanPathSpec extends ResourcePathSpec {
 public static SubscriptionPlanPathSpec subscriptionPlanPathSpec = new SubscriptionPlanPathSpec();

 public SubscriptionPlanPathSpec() {
  super(PathSpec.empty());
 }

 public SubscriptionPlanPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected SubscriptionPlanPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected SubscriptionPlanPathSpec bindSpec(AbstractPathSpec spec) {
  return new SubscriptionPlanPathSpec(spec);
 }
}