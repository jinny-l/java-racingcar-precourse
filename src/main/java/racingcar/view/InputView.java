package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.CarName;
import racingcar.information.ErrorMessage;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(%s) 기준으로 구분)%n";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String INPUT_ATTEMPTS = "시도할 회수는 몇회인가요?";

    /**
     * 자동차 이름을 입력할 때 사용하는 메서드
     * @return 2개 이상 입력 시, 쉼표 구분 여부를 검증하고 입력 값을 반환함
     */
    public static List<String> readCarName() {
        System.out.printf(INPUT_CAR_NAME, CAR_NAME_DELIMITER);
        String input = readInput();
        validateSeparatedByComma(input, CAR_NAME_DELIMITER);
        return Stream.of(input.split("\\s*" + CAR_NAME_DELIMITER + "\\s*"))
                .collect(Collectors.toList());
    }

    public static void validateSeparatedByComma(String input, String delimiter) {
        if (input.length() > CarName.getCarNameLength() && !input.contains(delimiter)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 시도 회수를 입력할 때 사용하는 메서드
     * @return 정수 여부를 검증하고 입력 값을 반환함
     */

    public static int readAttempts() {
        System.out.println(INPUT_ATTEMPTS);
        String input = readInput();
        return validateInteger(input);
    }

    public static int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_INPUT_TYPE_ERROR.getMessage());
        }
    }

    /**
     * 사용자의 입력을 받는 메서드
     * @return 공백을 검증하고 입력 값을 반환함
     */
    private static String readInput() {
        String input = Console.readLine().trim();
        validateHasInput(input);
        return input;
    }

    private static void validateHasInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY_ERROR.getMessage());
        }
    }

}
