package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class MealPlanningRestaurantConstraintPathSpec extends ResourcePathSpec {
 public static MealPlanningRestaurantConstraintPathSpec mealPlanningRestaurantConstraintPathSpec = new MealPlanningRestaurantConstraintPathSpec();

 public MealPlanningRestaurantConstraintPathSpec() {
  super(PathSpec.empty());
 }

 public MealPlanningRestaurantConstraintPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected MealPlanningRestaurantConstraintPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected MealPlanningRestaurantConstraintPathSpec bindSpec(AbstractPathSpec spec) {
  return new MealPlanningRestaurantConstraintPathSpec(spec);
 }
}
