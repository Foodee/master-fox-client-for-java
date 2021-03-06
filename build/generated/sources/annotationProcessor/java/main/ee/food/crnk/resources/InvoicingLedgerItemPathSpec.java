package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class InvoicingLedgerItemPathSpec extends ResourcePathSpec {
 public static InvoicingLedgerItemPathSpec invoicingLedgerItemPathSpec = new InvoicingLedgerItemPathSpec();

 public InvoicingLedgerItemPathSpec() {
  super(PathSpec.empty());
 }

 public InvoicingLedgerItemPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected InvoicingLedgerItemPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected InvoicingLedgerItemPathSpec bindSpec(AbstractPathSpec spec) {
  return new InvoicingLedgerItemPathSpec(spec);
 }
}
