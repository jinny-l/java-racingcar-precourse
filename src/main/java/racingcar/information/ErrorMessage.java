package racingcar.information;

import racingcar.domain.CarName;
import racingcar.view.InputView;

public enum ErrorMessage {

    INPUT_IS_EMPTY_ERROR("입력 값이 없습니다."),
    NOT_SEPARATED_BY_COMMA_ERROR(String.format(
            "2대 이상의 자동차 입력 시, 이름은 쉼표(%s)로 구분해 주세요.", InputView.getCarNameDelimiter())),
    NOT_VALID_INPUT_TYPE_ERROR("시도 회수는 숫자만 입력 가능합니다."),
    NOT_VALID_ATTEMPTS_NUMBER_ERROR(String.format(
            "시도 회수는 %d이상의 숫자를 입력해 주세요.", GameRule.ATTEMPTS_MIN_NUMBER.getNumber())
    ),
    NOT_VALID_NAME_LENGTH_ERROR(String.format("이름은 %s자 이하로 입력 가능합니다.", CarName.getCarNameLength())),
    NOT_UNIQUE_NAME_ERROR("중복된 이름은 입력이 불가능합니다.");

    private static final String ERROR = "[ERROR] ";

    private final String message;

    ErrorMessage(String errorMessage) {
        this.message = errorMessage;
    }

    public String getMessage() {
        return ERROR + message;
    }

}
