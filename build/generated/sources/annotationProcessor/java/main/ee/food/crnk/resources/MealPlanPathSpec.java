package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class MealPlanPathSpec extends ResourcePathSpec {
 public static MealPlanPathSpec mealPlanPathSpec = new MealPlanPathSpec();

 public MealPlanPathSpec() {
  super(PathSpec.empty());
 }

 public MealPlanPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected MealPlanPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected MealPlanPathSpec bindSpec(AbstractPathSpec spec) {
  return new MealPlanPathSpec(spec);
 }
}