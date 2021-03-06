package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class DriverPingPathSpec extends ResourcePathSpec {
 public static DriverPingPathSpec driverPingPathSpec = new DriverPingPathSpec();

 public DriverPingPathSpec() {
  super(PathSpec.empty());
 }

 public DriverPingPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected DriverPingPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected DriverPingPathSpec bindSpec(AbstractPathSpec spec) {
  return new DriverPingPathSpec(spec);
 }
}
