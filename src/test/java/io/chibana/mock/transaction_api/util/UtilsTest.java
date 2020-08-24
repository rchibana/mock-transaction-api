package io.chibana.mock.transaction_api.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {20, 30, 51, 42, 80, 60, 120, 50})
    public void testRandomString(int value) {
        String result = Utils.generateRandomString(value, 10);
        assertTrue(result.length() <= value);
        assertTrue(result.length() >= 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 30000, 6000 , -7, 8000, 92})
    public void testRandomBigDecimal(Integer maxValue) {
        Integer minValue = -999999999;
        BigInteger result = Utils.generateRandomBigInteger(maxValue, minValue);
        assertTrue(result.intValueExact() <= maxValue);
        assertTrue(result.intValueExact() >= minValue);
    }

}
