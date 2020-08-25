package io.chibana.mock.transaction_api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class MonthValidator implements ConstraintValidator<Month, Integer> {

    private static final Integer MIN_VALUE = 1;
    private static final Integer MAX_VALUE = 12;

    @Override
    public boolean isValid(Integer monthValue, ConstraintValidatorContext context) {
        return monthValue <= MAX_VALUE && monthValue >= MIN_VALUE;
    }
}

