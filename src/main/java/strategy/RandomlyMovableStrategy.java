package strategy;

import nextstep.utils.Randoms;

public class RandomlyMovableStrategy implements MovableStrategy{
    private static final int RANDOM_NUMBER_MIN_VALUE = 0;
    private static final int RANDOM_NUMBER_MAX_VALUE = 9;
    private static final int STANDARD_NUMBER_TO_MOVE = 4;

    private final int lowerBound;
    private final int upperBound;

    public RandomlyMovableStrategy() {
        this(RANDOM_NUMBER_MIN_VALUE, RANDOM_NUMBER_MAX_VALUE);
    }

    private RandomlyMovableStrategy(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public static RandomlyMovableStrategy newInstance() {
        return new RandomlyMovableStrategy();
    }

    public static RandomlyMovableStrategy of(int lowerBound, int upperBound) {
        return new RandomlyMovableStrategy(lowerBound, upperBound);
    }

    public boolean isMovable() {
        if (Randoms.pickNumberInRange(lowerBound, upperBound) >= STANDARD_NUMBER_TO_MOVE) {
            return true;
        }
        return false;
    }
}
