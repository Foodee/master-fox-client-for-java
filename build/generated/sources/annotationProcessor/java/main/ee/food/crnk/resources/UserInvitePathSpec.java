package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class UserInvitePathSpec extends ResourcePathSpec {
 public static UserInvitePathSpec userInvitePathSpec = new UserInvitePathSpec();

 public UserInvitePathSpec() {
  super(PathSpec.empty());
 }

 public UserInvitePathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected UserInvitePathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected UserInvitePathSpec bindSpec(AbstractPathSpec spec) {
  return new UserInvitePathSpec(spec);
 }
}