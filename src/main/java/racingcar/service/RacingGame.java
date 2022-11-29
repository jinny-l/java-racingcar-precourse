package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

/**
 * 자동차 게임을 관리하는 객체
 */

public class RacingGame {

    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    /**
     * 우승자를 찾을 때 사용하는 메서드
     * @return 우승자 이름을 반환함
     */
    public List<String> getWinnerNames() {
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.getCarsPositions().stream()
                .max(Integer::compare)
                .orElseThrow(IllegalArgumentException::new);
//        return cars.getCarsPositions().stream()
//                .mapToInt(car -> car)
//                .max()
//                .orElseThrow(() -> new IllegalArgumentException());
    }

}
