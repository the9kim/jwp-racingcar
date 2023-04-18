package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {
    private static final String CAR_LOCATION = "-";
    private static final String PRINT_CAR_LOCATION = "%s : %s\n";
    private static final String WINNER_DELIMITER = ", ";
    private static final String PRINT_WINNER = "%s가 최종 우승했습니다.\n";

    public void printResult(Cars cars) {
        for (Car car : cars.getCars()) {
            String location = CAR_LOCATION.repeat(car.getLocation());
            System.out.printf(PRINT_CAR_LOCATION, car.getName(), location);
        }
        System.out.println();
    }

    public void printWinner(List<String> winner) {
        System.out.printf(PRINT_WINNER, String.join(WINNER_DELIMITER, winner));
    }
}
