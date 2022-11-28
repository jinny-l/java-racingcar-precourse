package racingcar.controller;

import racingcar.domain.Attempts;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private CarNames carNames;
    private Attempts attempts;
    private Cars cars;
    private int numberOfAttempts;

    public void run() {
        initialize();
        printResult();
        printWinner();
    }

    /**
     * 게임 시작 시 사용하는 메서드
     */
    private void initialize() {
        readCarName();
        readAttempts();
        cars = new Cars(carNames.getNames());
        numberOfAttempts = attempts.get();
    }

    private void readCarName() {
        try {
            carNames = new CarNames(InputView.readCarName());
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            readCarName();
        }
    }

    private void readAttempts() {
        try {
            attempts = new Attempts(InputView.readAttempts());
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            readAttempts();
        }
    }

    /**
     * 실행 결과 출력 시 사용하는 메서드
     */
    private void printResult() {
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.move();
            OutputView.printResult(cars.getCarsInformation());
        }
    }

    /**
     * 우승자 출력 시 사용하는 메서드
     */
    private void printWinner() {
        RacingGame racingGame = new RacingGame(cars);
        OutputView.printWinner(racingGame.getWinnerNames());
    }

}
