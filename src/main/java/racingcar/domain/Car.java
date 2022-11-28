package racingcar.domain;

import racingcar.information.GameRule;

/**
 * 자동차 1대를 관리하는 객체
 */

public class Car {

    private static final String POSITION_EXPRESSION = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    /**
     * 자동차를 한 칸 이동할 때 사용하는 메서드
     * @param number : 랜덤 숫자
     */
    public void moveForward(int number) {
        if (number >= GameRule.MOVE_FORWARD.getNumber()) {
            position++;
        }
    }

    /**
     * 자동차가 이동한 결과를 표현할 때 사용하는 메서드
     * @return 이동한 만큼 "-"를 String으로 반환함
     */
    @Override
    public String toString() {
        return POSITION_EXPRESSION.repeat(position);
    }

}
