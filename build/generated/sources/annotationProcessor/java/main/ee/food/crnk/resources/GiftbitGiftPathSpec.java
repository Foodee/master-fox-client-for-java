package ee.food.crnk.resources;

import io.crnk.core.queryspec.AbstractPathSpec;
import io.crnk.core.queryspec.PathSpec;
import io.crnk.core.queryspec.internal.typed.ResourcePathSpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class GiftbitGiftPathSpec extends ResourcePathSpec {
 public static GiftbitGiftPathSpec giftbitGiftPathSpec = new GiftbitGiftPathSpec();

 public GiftbitGiftPathSpec() {
  super(PathSpec.empty());
 }

 public GiftbitGiftPathSpec(PathSpec pathSpec) {
  super(pathSpec);
 }

 protected GiftbitGiftPathSpec(AbstractPathSpec spec) {
  super(spec);
 }

 protected GiftbitGiftPathSpec bindSpec(AbstractPathSpec spec) {
  return new GiftbitGiftPathSpec(spec);
 }
}
