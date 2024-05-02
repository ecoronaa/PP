package utils;

import lombok.experimental.UtilityClass;

import java.util.UUID;

import static utils.RandomNumberUtils.generateRandomInteger;

/**
 * Utility class for generating credentials.
 */
@UtilityClass
public class RandomStringUtils {
    private static final int UNICODE_DECIMAL_UPPERCASE_A = 65;
    private static final int UNICODE_DECIMAL_UPPERCASE_Z = 90;
    private static final int UNICODE_DECIMAL_0 = 48;
    private static final int UNICODE_DECIMAL_9 = 57;
    private static final int UNICODE_DECIMAL_FIRST_CYRILLIC = 1024;
    private static final int UNICODE_DECIMAL_LAST_CYRILLIC = 1279;

    public static String generateRandomString(int length) {
        return UUID.randomUUID().toString().substring(0, length);
    }

    public static String generateRandomPassword(String email, int length) {
        StringBuilder password = new StringBuilder();
        password.append((char) generateRandomInteger(
                UNICODE_DECIMAL_UPPERCASE_A, UNICODE_DECIMAL_UPPERCASE_Z, true));
        password.append((char) generateRandomInteger(UNICODE_DECIMAL_0, UNICODE_DECIMAL_9, true));
        password.append(getLetterFromEmail(email));
        password.append((char) generateRandomInteger(
                UNICODE_DECIMAL_FIRST_CYRILLIC, UNICODE_DECIMAL_LAST_CYRILLIC, true));
        password.append(generateRandomString(length - password.length()));
        return password.toString();
    }

    private static char getLetterFromEmail(String email) {
        char emailChar;
        do {
            emailChar = email.charAt(generateRandomInteger(email.length()));
        } while (!Character.isLetter(emailChar));
        return emailChar;
    }
}
