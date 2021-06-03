package ee.food.crnk.exceptions.unprocessableEntity;

import io.crnk.core.engine.error.ErrorResponse;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public abstract class UnprocessableEntityException extends RuntimeException {


    public UnprocessableEntityException(String message) {
        super(message);
    }

    public abstract boolean appliesTo(ErrorResponse errorResponse);


    /**
     * This method is a Kludge to find any UnprocessableEntityExceptions that handle this error
     */
    public static Class<? extends UnprocessableEntityException> findExceptionFor(ErrorResponse errorResponse) {
        Reflections reflections = new Reflections("ee.food.crnk.exceptions.unprocessableEntity");
        Set<Class<? extends UnprocessableEntityException>> subTypesOf = reflections.getSubTypesOf(UnprocessableEntityException.class);

        return subTypesOf
                .stream()
                .filter(new Predicate<Class<? extends UnprocessableEntityException>>() {
                    @SneakyThrows
                    @Override
                    public boolean test(Class<? extends UnprocessableEntityException> aClass) {
                        return aClass.newInstance().appliesTo(errorResponse);
                    }
                })
                .findAny()
                .orElse(null);
    }

    /**
     * This method is a Kludge to find any UnprocessableEntityExceptions that handle this error
     */
    public static boolean anyApplyTo(ErrorResponse errorResponse) {
        return findExceptionFor(errorResponse) != null;
    }

}
