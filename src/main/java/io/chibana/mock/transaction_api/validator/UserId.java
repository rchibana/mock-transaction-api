package io.chibana.mock.transaction_api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserIdValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserId {

    String message() default "{userId.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
