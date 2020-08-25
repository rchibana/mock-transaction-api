package io.chibana.mock.transaction_api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class YearValidator implements ConstraintValidator<Year, Integer> {

    private static final Integer MIN_VALUE = 1;
    private static final Integer MAX_VALUE = 9999;

    @Override
    public boolean isValid(Integer yearValue, ConstraintValidatorContext context) {
        return yearValue <= MAX_VALUE && yearValue >= MIN_VALUE;
    }
}

