package racingcar.domain;

import racingcar.information.GameRule;
import racingcar.util.NumberGenerator;

/**
 * 자동차 1대를 관리하는 객체
 */

public class Car {

    private static final String POSITION_EXPRESSION = "-";

    private final String name;
    private int position = 0;
    private NumberGenerator numberGenerator;

    /**
     * 프로그램 구현에 사용하는 생성자
     */
    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    /**
     * 테스트에 사용하는 생성자
     */
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    /**
     * 자동차를 한 칸 이동할 때 사용하는 메서드
     */
    public void moveForward() {
        int number = numberGenerator.generate();
        if (number >= GameRule.MOVE_FORWARD.getNumber()) {
            position++;
        }
    }

    /**
     * 자동차가 이동한 결과를 표현할 때 사용하는 메서드
     * @return 이동한 만큼 "-"를 반환
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(POSITION_EXPRESSION);
        }
        return stringBuilder.toString();
    }

}
