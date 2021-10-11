package domain;

import java.util.Objects;

public class GameTryCount extends PositiveNumber {
    private static final String GAME_TRY_COUNT_IS_NULL_OR_EMPTY_EXCEPTION_STATEMENT = "게임횟수의 값이 null 또는 빈문자 입니다.";
    private static final String GAME_TRY_COUNT_IS_NOT_POSITIVE_NUMBER_PATTERN_EXCEPTION_STATEMENT = "게임횟수의 값이 양수 또는 숫자가 아닙니다.";
    private static final String NUMBER_PATTERN = "^[0-9]+$";

    private GameTryCount(int gameTryCount) {
        super(gameTryCount);
    }

    private GameTryCount(String gameTryCount) {
        this(Integer.valueOf(gameTryCount));
    }

    public static GameTryCount from(int gameTryCount) {
        return new GameTryCount(gameTryCount);
    }

    public static GameTryCount from(String gameTryCount) {
        validate(gameTryCount);
        return new GameTryCount(gameTryCount);
    }

    private static void validate(String gameTryCount) {
        if (Objects.isNull(gameTryCount) || gameTryCount.isEmpty()) {
            throw new IllegalArgumentException(GAME_TRY_COUNT_IS_NULL_OR_EMPTY_EXCEPTION_STATEMENT);
        }

        if (!gameTryCount.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(GAME_TRY_COUNT_IS_NOT_POSITIVE_NUMBER_PATTERN_EXCEPTION_STATEMENT);
        }
    }

    protected boolean enableZero() {
        return false;
    }

    public boolean isGameEnd() {
        return isZero();
    }
}
