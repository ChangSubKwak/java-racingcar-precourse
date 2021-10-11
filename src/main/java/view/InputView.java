package view;

import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;

public class InputView {
    private static final String INPUT_CAR_NAMES_STATEMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_GAME_TRY_COUNT_STATEMENT = "시도할 횟수는 몇회인가요?";
    private static final String INPUT_CAR_NAMES_SEPARATOR = ",";

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_STATEMENT);
        String[] carNames = Console.readLine().split(INPUT_CAR_NAMES_SEPARATOR);
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return Arrays.asList(carNames);
    }

    public String inputGameTryCount() {
        System.out.println(INPUT_GAME_TRY_COUNT_STATEMENT);
        return Console.readLine();
    }
}
