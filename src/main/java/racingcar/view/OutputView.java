package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String OUTPUT_RESULT = "실행 결과";
    private static final String NAME_DELIMITER = " : ";
    private static final String WINNER_DELIMITER = ",";
    private static final String OUTPUT_WINNER = "최종 우승자 : ";

    /**
     * 게임 실행 결과를 출력할 때 사용하는 메서드
     * @param carsInformation : Car의 name과 position(String) 정보
     */
    public static void printResult(Map<String, String> carsInformation) {
        StringBuilder stringBuilder = new StringBuilder();
        carsInformation.forEach((key, value) -> stringBuilder
                .append(key)
                .append(NAME_DELIMITER)
                .append(value)
                .append("\n"));
        System.out.println(stringBuilder);
    }

    public static void printMessage() {
        System.out.println(OUTPUT_RESULT);
    }

    /**
     * 우승자를 출력할 때 사용하는 메서드
     * @param names : RacingGame 우승자 name 정보
     */
    public static void printWinner(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OUTPUT_WINNER);
        names.forEach(name -> stringBuilder
                .append(name)
                .append(WINNER_DELIMITER)
        );
        stringBuilder.setLength(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }

}
