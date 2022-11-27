package racingcar.domain;

import racingcar.information.GameRule;

public class Car {

    private static final int NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static int getNameLength() {
        return NAME_LENGTH;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void moveForward(int number) {
        if (number >= GameRule.MOVE_FORWARD.getNumber()) {
            position++;
        }
    }

}