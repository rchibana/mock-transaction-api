package io.chibana.mock.transaction_api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MonthValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Month {

    String message() default "{month.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
