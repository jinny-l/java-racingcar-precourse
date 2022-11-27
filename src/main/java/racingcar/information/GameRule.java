package racingcar.information;

public enum GameRule {

    MOVE_FORWARD(4),
    ATTEMPTS_MIN_NUMBER(1);

    private final int number;

    GameRule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
