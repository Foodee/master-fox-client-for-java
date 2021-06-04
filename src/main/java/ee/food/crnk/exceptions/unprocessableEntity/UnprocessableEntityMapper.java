package ee.food.crnk.exceptions.unprocessableEntity;

import ee.food.crnk.exceptions.unprocessableEntity.orders.RestaurantAtCapacity;
import io.crnk.core.engine.document.ErrorData;
import io.crnk.core.engine.error.ErrorResponse;
import io.crnk.core.engine.error.ExceptionMapper;
import lombok.SneakyThrows;
import lombok.val;

import java.util.stream.Collectors;

public class UnprocessableEntityMapper implements ExceptionMapper<UnprocessableEntityException> {

    public static final int HTTP_ERROR_CODE = 422;

    @Override
    public ErrorResponse toErrorResponse(UnprocessableEntityException exception) {
        return null;
    }

    @SneakyThrows
    @Override
    public UnprocessableEntityException fromErrorResponse(ErrorResponse errorResponse) {
        val klass = UnprocessableEntityException.findExceptionFor(errorResponse);

        if (klass != null) {
            return klass.newInstance();
        } else {
            val errors = errorResponse.getErrors();
            val messages = errors.stream().map(ErrorData::getTitle).collect(Collectors.joining(","));
            return new UnhandledUnprocessableEntityException(messages, errorResponse);
        }
    }

    @Override
    public boolean accepts(ErrorResponse errorResponse) {
        return errorResponse.getHttpStatus() == HTTP_ERROR_CODE;
    }
}
