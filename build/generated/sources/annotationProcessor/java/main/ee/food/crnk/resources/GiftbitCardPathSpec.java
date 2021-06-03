package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class GiftbitCardPathSpec extends ResourcePathSpec {
 public static GiftbitCardPathSpec giftbitCardPathSpec = new GiftbitCardPathSpec();

 public GiftbitCardPathSpec() {
  super(PathSpec.empty());
 }

 public GiftbitCardPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected GiftbitCardPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected GiftbitCardPathSpec bindSpec(AbstractPathSpec spec) {
  return new GiftbitCardPathSpec(spec);
 }
}