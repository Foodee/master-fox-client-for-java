package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class ServiceTimePathSpec extends ResourcePathSpec {
 public static ServiceTimePathSpec serviceTimePathSpec = new ServiceTimePathSpec();

 public ServiceTimePathSpec() {
  super(PathSpec.empty());
 }

 public ServiceTimePathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected ServiceTimePathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected ServiceTimePathSpec bindSpec(AbstractPathSpec spec) {
  return new ServiceTimePathSpec(spec);
 }
}