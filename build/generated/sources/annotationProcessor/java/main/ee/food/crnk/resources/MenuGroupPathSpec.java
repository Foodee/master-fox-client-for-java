package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class MenuGroupPathSpec extends ResourcePathSpec {
 public static MenuGroupPathSpec menuGroupPathSpec = new MenuGroupPathSpec();

 public MenuGroupPathSpec() {
  super(PathSpec.empty());
 }

 public MenuGroupPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected MenuGroupPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected MenuGroupPathSpec bindSpec(AbstractPathSpec spec) {
  return new MenuGroupPathSpec(spec);
 }
}
