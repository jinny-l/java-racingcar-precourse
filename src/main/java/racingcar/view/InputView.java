package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.util.InputValidator;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(%s) 기준으로 구분%n)";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String INPUT_ATTEMPTS = "시도할 회수는 몇회인가요?";

    public static List<String> readCarName() {
        System.out.printf(INPUT_CAR_NAME, CAR_NAME_DELIMITER);
        String input = readInput();
        InputValidator.validateSeparatedByComma(input);
        return Stream.of(input.split(CAR_NAME_DELIMITER))
                .collect(Collectors.toList());
    }

    public static int readAttempts() {
        System.out.println(INPUT_ATTEMPTS);
        String input = readInput();
        int attempts = InputValidator.validateInteger(input);
        InputValidator.validateNumberRange(attempts);
        return attempts;
    }

    private static String readInput() {
        return Console.readLine().trim();
    }
}
