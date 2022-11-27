package racingcar.information;

public enum GameRule {

    MOVE_FORWARD(4);

    private final int number;

    GameRule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
