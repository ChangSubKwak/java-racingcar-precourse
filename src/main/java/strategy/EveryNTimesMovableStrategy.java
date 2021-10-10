package strategy;

public class EveryNTimesMovableStrategy implements MovableStrategy {
    private static final String TIMES_MUST_NOT_BE_LESS_THAN_ZERO_EXCEPTION_STATEMENT = "횟수 주기값은 0이하가 될 수 없습니다.";
    private static final String COUNT_MUST_NOT_BE_LESS_THAN_ZERO_EXCEPTION_STATEMENT = "카운트 값은 0미만이 될 수 없습니다..";
    private static final int INITIAL_COUNT = 0;
    private static final int ZERO = 0;

    private final int times;
    private int count;

    private EveryNTimesMovableStrategy(int times) {
        this(times, INITIAL_COUNT);
    }

    private EveryNTimesMovableStrategy(int times, int count) {
        validate(times, count);
        this.count = count;
        this.times = times;
    }

    public static EveryNTimesMovableStrategy from(int times) {
        return new EveryNTimesMovableStrategy(times);
    }

    public static EveryNTimesMovableStrategy of(int times, int count) {
        return new EveryNTimesMovableStrategy(times, count);
    }

    private void validate(int times, int count) {
        if (times <= ZERO) {
            throw new IllegalArgumentException(TIMES_MUST_NOT_BE_LESS_THAN_ZERO_EXCEPTION_STATEMENT);
        }

        if (count < ZERO) {
            throw new IllegalArgumentException(COUNT_MUST_NOT_BE_LESS_THAN_ZERO_EXCEPTION_STATEMENT);
        }
    }

    public boolean isMovable() {
        count++;
        return count % times == 0;
    }
}
