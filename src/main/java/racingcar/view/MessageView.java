package racingcar.view;

public class MessageView {

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void printCarNameMessage() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    public static void printTryCountMessage() {
        System.out.println(TRY_COUNT_MESSAGE);
    }
}
