package ee.food.crnk.resources;

import io.crnk.core.queryspec.internal.typed.TypedQuerySpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class CompanyQuerySpec extends TypedQuerySpec<Company, CompanyPathSpec> {
 public CompanyQuerySpec() {
  super(ee.food.crnk.resources.Company.class, new CompanyPathSpec());
 }
}