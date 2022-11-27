package racingcar.domain;

/**
 * 자동차 이름 1개를 관리하는 객체
 */

public class CarName {

    private static final int CAR_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static int getCarNameLength() {
        return CAR_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

}
