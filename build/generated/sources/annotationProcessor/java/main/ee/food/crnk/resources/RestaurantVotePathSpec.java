package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class RestaurantVotePathSpec extends ResourcePathSpec {
 public static RestaurantVotePathSpec restaurantVotePathSpec = new RestaurantVotePathSpec();

 public RestaurantVotePathSpec() {
  super(PathSpec.empty());
 }

 public RestaurantVotePathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected RestaurantVotePathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected RestaurantVotePathSpec bindSpec(AbstractPathSpec spec) {
  return new RestaurantVotePathSpec(spec);
 }
}