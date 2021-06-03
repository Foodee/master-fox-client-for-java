package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class MealPlanningLogRecordPathSpec extends ResourcePathSpec {
 public static MealPlanningLogRecordPathSpec mealPlanningLogRecordPathSpec = new MealPlanningLogRecordPathSpec();

 public MealPlanningLogRecordPathSpec() {
  super(PathSpec.empty());
 }

 public MealPlanningLogRecordPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected MealPlanningLogRecordPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected MealPlanningLogRecordPathSpec bindSpec(AbstractPathSpec spec) {
  return new MealPlanningLogRecordPathSpec(spec);
 }
}
