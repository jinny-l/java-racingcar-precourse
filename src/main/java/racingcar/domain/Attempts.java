package racingcar.domain;

import racingcar.information.GameRule;

/**
 * 시도 회수를 관리하는 객체
 */

public class Attempts {

    private final int attempts;

    public Attempts(int attempts) {
        validateNumberRange(attempts);
        this.attempts = attempts;
    }

    public int get() {
        return attempts;
    }

    public static void validateNumberRange(int attempts) {
        if (attempts < GameRule.ATTEMPTS_MIN_NUMBER.getNumber()) {
            throw new IllegalArgumentException();
        }
    }
}
