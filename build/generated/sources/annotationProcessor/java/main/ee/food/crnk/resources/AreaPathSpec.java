package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class AreaPathSpec extends ResourcePathSpec {
 public static AreaPathSpec areaPathSpec = new AreaPathSpec();

 public AreaPathSpec() {
  super(PathSpec.empty());
 }

 public AreaPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected AreaPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected AreaPathSpec bindSpec(AbstractPathSpec spec) {
  return new AreaPathSpec(spec);
 }
}
