package ee.food.crnk.exceptions.unprocessableEntity.orders;

import ee.food.crnk.exceptions.unprocessableEntity.UnprocessableEntityException;
import io.crnk.core.engine.document.ErrorData;
import io.crnk.core.engine.error.ErrorResponse;

import java.util.function.Predicate;

public class RestaurantAtCapacity extends UnprocessableEntityException {

    public RestaurantAtCapacity() {
        super("The restaurant you've selected is at capacity for the date & time you've specified, please select another one.");
    }

    @Override
    public boolean appliesTo(ErrorResponse errorResponse) {
        return errorResponse.getErrors().stream().anyMatch(new Predicate<ErrorData>() {
            @Override
            public boolean test(ErrorData errorData) {
                return errorData.getSourcePointer().equals("/data/attributes/restaurant-capacity");
            }
        });
    }
}
