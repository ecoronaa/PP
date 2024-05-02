package utils;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomNumberUtils {
    private static final int DEFAULT_MIN = 0;
    private static final boolean DEFAULT_INCLUSIVITY = false;

    public static int generateRandomInteger(int min, int max, boolean inclusive) {
        if (inclusive) {
            ++max;
        }
        return (new Random()).nextInt(max - min) + min;
    }

    public static int generateRandomInteger(int max, boolean inclusive) {
        return generateRandomInteger(DEFAULT_MIN, max, inclusive);
    }

    public static int generateRandomInteger(int max) {
        return generateRandomInteger(DEFAULT_MIN, max, DEFAULT_INCLUSIVITY);
    }
}
