package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class EventPathSpec extends ResourcePathSpec {
 public static EventPathSpec eventPathSpec = new EventPathSpec();

 public EventPathSpec() {
  super(PathSpec.empty());
 }

 public EventPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected EventPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected EventPathSpec bindSpec(AbstractPathSpec spec) {
  return new EventPathSpec(spec);
 }
}
