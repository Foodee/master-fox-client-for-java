package ee.food.crnk.resources;

import io.crnk.core.queryspec.internal.typed.TypedQuerySpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class ContactQuerySpec extends TypedQuerySpec<Contact, ContactPathSpec> {
 public ContactQuerySpec() {
  super(ee.food.crnk.resources.Contact.class, new ContactPathSpec());
 }
}