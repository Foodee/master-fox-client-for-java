package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class SalesforceCasePathSpec extends ResourcePathSpec {
 public static SalesforceCasePathSpec salesforceCasePathSpec = new SalesforceCasePathSpec();

 public SalesforceCasePathSpec() {
  super(PathSpec.empty());
 }

 public SalesforceCasePathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected SalesforceCasePathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected SalesforceCasePathSpec bindSpec(AbstractPathSpec spec) {
  return new SalesforceCasePathSpec(spec);
 }
}
