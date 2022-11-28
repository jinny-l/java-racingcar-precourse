package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.NumberGenerator;


class CarTest {

    @DisplayName("자동차 이동 불가 케이스 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void unableToMoveCase(int input) {
        NumberGenerator numberGenerator = new TestNumberGenerator(input);
        Car car = new Car("A", numberGenerator);
        car.moveForward();
        assertEquals(0, car.getPosition());
    }

    @DisplayName("자동차 이동 가능 케이스 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void ableToMoveCase(int input) {
        NumberGenerator numberGenerator = new TestNumberGenerator(input);
        Car car = new Car("A", numberGenerator);
        car.moveForward();
        assertEquals(1, car.getPosition());
    }

    public static class TestNumberGenerator implements NumberGenerator {
        private final int testNumber;

        TestNumberGenerator(int testNumber) {
            this.testNumber = testNumber;
        }

        @Override
        public int generate() {
            return testNumber;
        }
    }
}
