package io.chibana.mock.transaction_api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserIdValidator implements ConstraintValidator<UserId, Integer> {

    private static final Integer MIN_VALUE = 1000;
    private static final Integer MAX_VALUE = 100000000;

    @Override
    public boolean isValid(Integer userId, ConstraintValidatorContext context) {
        return userId <= MAX_VALUE && userId >= MIN_VALUE;
    }
}
