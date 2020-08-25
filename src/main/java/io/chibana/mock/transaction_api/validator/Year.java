package io.chibana.mock.transaction_api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = YearValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Year {

    String message() default "{year.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
