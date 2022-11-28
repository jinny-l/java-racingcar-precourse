package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;


class RacingGameTest {

    @DisplayName("우승자를 1명을 찾는 테스트")
    @Test
    void getWinnerNameTest() {
        RacingGame racingGame = new RacingGame(new Cars(
                new Car("A", 1),
                new Car("B", 2)
        ));
        assertEquals(Arrays.asList("B"), racingGame.getWinnerNames());
    }

    @DisplayName("우승자를 여러 명을 찾는 테스트")
    @Test
    void getWinnerNamesTest() {
        RacingGame racingGame = new RacingGame(new Cars(
                new Car("A", 2),
                new Car("B", 2)
        ));
        assertEquals(Arrays.asList("A", "B"), racingGame.getWinnerNames());
    }

}
