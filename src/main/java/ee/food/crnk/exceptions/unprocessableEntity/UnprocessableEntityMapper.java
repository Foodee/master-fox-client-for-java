package ee.food.crnk.exceptions.unprocessableEntity;

import ee.food.crnk.exceptions.unprocessableEntity.orders.RestaurantAtCapacity;
import io.crnk.core.engine.error.ErrorResponse;
import io.crnk.core.engine.error.ExceptionMapper;
import lombok.SneakyThrows;

public class UnprocessableEntityMapper implements ExceptionMapper<UnprocessableEntityException> {

    public static final int HTTP_ERROR_CODE = 422;

    @Override
    public ErrorResponse toErrorResponse(UnprocessableEntityException exception) {
        return null;
    }

    @SneakyThrows
    @Override
    public UnprocessableEntityException fromErrorResponse(ErrorResponse errorResponse) {
        return UnprocessableEntityException.findExceptionFor(errorResponse).newInstance();
    }

    @Override
    public boolean accepts(ErrorResponse errorResponse) {
        return errorResponse.getHttpStatus() == HTTP_ERROR_CODE && UnprocessableEntityException.anyApplyTo(errorResponse);
    }
}
