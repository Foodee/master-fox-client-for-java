package ee.food.crnk.exceptions.unprocessableEntity;

import io.crnk.core.engine.error.ErrorResponse;

/**
 * This class is for when we do not have a handler for the specific type of 422 error
 * it grants access to the error response for inspection elsewhere.
 */
public class UnhandledUnprocessableEntityException extends UnprocessableEntityException {

    private ErrorResponse errorResponse;

    public UnhandledUnprocessableEntityException() {
        super("");
    }

    public UnhandledUnprocessableEntityException(String message) {
        super(message);
    }

    public UnhandledUnprocessableEntityException(String message, ErrorResponse errorResponse) {
        super(message);
        this.errorResponse = errorResponse;
    }

    @Override
    public boolean appliesTo(ErrorResponse errorResponse) {
        return false;
    }

    public ErrorResponse getErrorResponse() {
        return this.errorResponse;
    }
}
