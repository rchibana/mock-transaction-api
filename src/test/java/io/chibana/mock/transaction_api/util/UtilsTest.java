package io.chibana.mock.transaction_api.util;

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
    @ValueSource(ints = {2, 3, 6 ,7, 8, 9})
    public void testRandomBigDecimal(int value) {
        BigInteger result = Utils.generateRandomBigInteger(value, 1);
        assertTrue(result.toString().length() <= value);
        assertTrue(result.toString().length() >= 1);
    }

}
