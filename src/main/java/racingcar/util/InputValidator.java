package racingcar.util;

import racingcar.Car;
import racingcar.information.GameRule;

public class InputValidator {

    public static int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberRange(int attempts) {
        if (attempts < GameRule.ATTEMPTS_MIN_NUMBER.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateSeparatedByComma(String input) {
        if (input.length() > Car.getNameLength()) {
            throw new IllegalArgumentException();
        }
    }
}
