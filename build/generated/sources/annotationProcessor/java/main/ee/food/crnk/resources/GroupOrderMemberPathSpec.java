package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class GroupOrderMemberPathSpec extends ResourcePathSpec {
 public static GroupOrderMemberPathSpec groupOrderMemberPathSpec = new GroupOrderMemberPathSpec();

 public GroupOrderMemberPathSpec() {
  super(PathSpec.empty());
 }

 public GroupOrderMemberPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected GroupOrderMemberPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected GroupOrderMemberPathSpec bindSpec(AbstractPathSpec spec) {
  return new GroupOrderMemberPathSpec(spec);
 }
}
