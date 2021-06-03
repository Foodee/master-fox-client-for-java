package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class AreaClosurePathSpec extends ResourcePathSpec {
 public static AreaClosurePathSpec areaClosurePathSpec = new AreaClosurePathSpec();

 public AreaClosurePathSpec() {
  super(PathSpec.empty());
 }

 public AreaClosurePathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected AreaClosurePathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected AreaClosurePathSpec bindSpec(AbstractPathSpec spec) {
  return new AreaClosurePathSpec(spec);
 }
}