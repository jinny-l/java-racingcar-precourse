package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExceptionTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력 값이 없을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void emptyInputTest(String input) {
        assertSimpleTest(
                () -> {
                    runException(input);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("이름이 5자가 넘어갈 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "가나다라마바", "ABCDEF"})
    void overSizeTest(String input) {
        assertSimpleTest(
            () -> {
                runException(input);
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @DisplayName("2대 이상 입력 시 쉼표로 구분하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = "12345 이름1 이름2")
    void nameSeparatedByCommaTest(String input) {
        assertSimpleTest(
                () -> {
                    runException(input);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("중복 이름 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = "포비, 크롱, 포비")
    void uniqueNameTest(String input) {
        assertSimpleTest(
                () -> {
                    runException(input);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("시도 회수를 숫자로 입력하지 않았을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = "숫자")
    void attemptsInputTypeTest(String input) {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", input, "1");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("시도 회수를 1이상 입력하지 않았을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void attemptsNumberRangeTest(String input) {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", input, "1");
                    assertThat(output()).contains(ERROR_MESSAGE);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
