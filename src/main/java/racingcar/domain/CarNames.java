package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차 이름 여러개를 관리하는 객체
 */

public class CarNames {

    private final List<CarName> carNames = new ArrayList<>();

    public CarNames(List<String> carNames) {
        validateUniqueName(carNames);
        for (String carName : carNames) {
            this.carNames.add(new CarName(carName));
        }
    }

    public List<String> getNames() {
        return carNames.stream()
                .map(CarName::getName)
                .collect(Collectors.toList());
    }

    private void validateUniqueName(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

}
