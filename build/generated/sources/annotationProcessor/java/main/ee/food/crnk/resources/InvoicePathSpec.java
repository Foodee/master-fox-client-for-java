package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class InvoicePathSpec extends ResourcePathSpec {
 public static InvoicePathSpec invoicePathSpec = new InvoicePathSpec();

 public InvoicePathSpec() {
  super(PathSpec.empty());
 }

 public InvoicePathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected InvoicePathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected InvoicePathSpec bindSpec(AbstractPathSpec spec) {
  return new InvoicePathSpec(spec);
 }
}
