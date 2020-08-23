package io.chibana.mock.transaction_api.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigInteger;
import java.util.Random;


public final class Utils {

    private static final Random RANDOM = new Random();

    public static String generateRandomString(int maxLength, int minLength) {
        final int randomValue = getRandomValue(maxLength, minLength);
        return RandomStringUtils.randomAlphabetic(randomValue);
    }

    public static BigInteger generateRandomBigInteger(int maxLength, int minLength) {
        final int randomValue = getRandomValue(maxLength, minLength);
        final String value = RandomStringUtils.randomNumeric(randomValue);
        return BigInteger.valueOf(Long.parseLong(value));
    }

    private static int getRandomValue(int maxLength, int minLength) {
        return RANDOM.nextInt(maxLength - minLength) + minLength;
    }

}
