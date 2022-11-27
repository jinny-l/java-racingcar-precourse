package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차 이름 여러개를 관리하는 객체
 */

public class CarNames {

    private final List<String> carNames;

    public CarNames(List<String> carNames) {
        validateUniqueName(carNames);
        this.carNames = carNames.stream()
                .map(name -> new CarName(name).getName())
                .collect(Collectors.toList());
    }

    public List<String> getCarNames() {
        return carNames;
    }

    private void validateUniqueName(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

}
