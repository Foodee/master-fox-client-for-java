package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class MenuPathSpec extends ResourcePathSpec {
 public static MenuPathSpec menuPathSpec = new MenuPathSpec();

 public MenuPathSpec() {
  super(PathSpec.empty());
 }

 public MenuPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected MenuPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected MenuPathSpec bindSpec(AbstractPathSpec spec) {
  return new MenuPathSpec(spec);
 }
}
