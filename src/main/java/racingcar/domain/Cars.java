package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;

/**
 * 자동차 여러 대를 관리하는 객체
 */

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    /**
     * 프로그램 구현에 사용하는 생성자
     */
    public Cars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName, new RandomNumberGenerator()));
        }
    }

    /**
     * 테스트에 사용하는 생성자
     */
    public Cars(Car car1, Car car2) {
        cars.add(car1);
        cars.add(car2);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getCarsNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> getCarsPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public Map<String, String> getCarsInformation() {
        return cars.stream()
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::toString
                ));
    }

    /**
     * 자동차 여러 대를 이동할 때 사용하는 메서드
     */
    public void move() {
        cars.forEach(Car::moveForward);
    }

}
