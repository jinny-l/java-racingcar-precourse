package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarsTest {

    @DisplayName("carNames getter 테스트")
    @Test
    void CarNamesGetterTest() {
        List<String> names = Arrays.asList("A", "B", "C");
        Cars cars = new Cars(names);
        assertEquals(cars.getCarsNames(), names);
    }

    @DisplayName("positions getter 테스트")
    @Test
    void positionsGetterTest() {
        Cars cars = new Cars(
                new Car("A", 1),
                new Car("B", 2));
        assertEquals(cars.getCarsPositions(), Arrays.asList(1, 2));
    }

    @DisplayName("carsInformation getter 테스트")
    @Test
    void CarsInformationGetterTest() {
        Cars cars = new Cars(
                new Car("A", 1),
                new Car("B", 2));
        Map<String, String> result = new TreeMap<String, String>() {{
                put("A", "-");
                put("B", "--");
            }};
        assertEquals(cars.getCarsInformation(), result);
    }

}
