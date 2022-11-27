package racingcar.domain;

import racingcar.information.GameRule;

public class Car {

    private final CarName name;
    private int position = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public CarName getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int number) {
        if (number >= GameRule.MOVE_FORWARD.getNumber()) {
            position++;
        }
    }

}
