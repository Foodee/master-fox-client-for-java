package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class MealPlanningEventPathSpec extends ResourcePathSpec {
 public static MealPlanningEventPathSpec mealPlanningEventPathSpec = new MealPlanningEventPathSpec();

 public MealPlanningEventPathSpec() {
  super(PathSpec.empty());
 }

 public MealPlanningEventPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected MealPlanningEventPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected MealPlanningEventPathSpec bindSpec(AbstractPathSpec spec) {
  return new MealPlanningEventPathSpec(spec);
 }
}
