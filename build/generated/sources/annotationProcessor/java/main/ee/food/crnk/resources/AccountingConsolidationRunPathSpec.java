package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class AccountingConsolidationRunPathSpec extends ResourcePathSpec {
 public static AccountingConsolidationRunPathSpec accountingConsolidationRunPathSpec = new AccountingConsolidationRunPathSpec();

 public AccountingConsolidationRunPathSpec() {
  super(PathSpec.empty());
 }

 public AccountingConsolidationRunPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected AccountingConsolidationRunPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected AccountingConsolidationRunPathSpec bindSpec(AbstractPathSpec spec) {
  return new AccountingConsolidationRunPathSpec(spec);
 }
}
