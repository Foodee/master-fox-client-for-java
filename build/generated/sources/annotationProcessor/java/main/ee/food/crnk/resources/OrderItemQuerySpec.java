package ee.food.crnk.resources;

import io.crnk.core.queryspec.internal.typed.TypedQuerySpec;
import javax.annotation.Generated;

@Generated("Generated by Crnk annotation processor")
public class OrderItemQuerySpec extends TypedQuerySpec<OrderItem, OrderItemPathSpec> {
 public OrderItemQuerySpec() {
  super(ee.food.crnk.resources.OrderItem.class, new OrderItemPathSpec());
 }
}
