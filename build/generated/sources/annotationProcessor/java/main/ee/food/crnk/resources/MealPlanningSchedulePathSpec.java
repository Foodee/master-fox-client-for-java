package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class MealPlanningSchedulePathSpec extends ResourcePathSpec {
 public static MealPlanningSchedulePathSpec mealPlanningSchedulePathSpec = new MealPlanningSchedulePathSpec();

 public MealPlanningSchedulePathSpec() {
  super(PathSpec.empty());
 }

 public MealPlanningSchedulePathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected MealPlanningSchedulePathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected MealPlanningSchedulePathSpec bindSpec(AbstractPathSpec spec) {
  return new MealPlanningSchedulePathSpec(spec);
 }
}