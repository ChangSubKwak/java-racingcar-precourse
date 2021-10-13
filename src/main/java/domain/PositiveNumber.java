package domain;

public abstract class PositiveNumber {
    private static final String POSITIVE_NUMBER_MUST_NOT_BE_NEGATIVE_EXCEPTION_STATEMENT = "음수값은 올바르지 않습니다.";
    private static final String MUST_NOT_BE_ZERO_EXCEPTION_STATEMENT = "값이 0이 되면 안됩니다.";
    private static final int ZERO_VALUE = 0;

    private int positiveNumber;

    protected PositiveNumber(int positiveNumber) {
        this.positiveNumber = positiveNumber;
        validate();
    }

    private void validate() {
        if (positiveNumber < ZERO_VALUE) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_MUST_NOT_BE_NEGATIVE_EXCEPTION_STATEMENT);
        }

        if (!enableZero() && isZero()) {
            throw new IllegalArgumentException(MUST_NOT_BE_ZERO_EXCEPTION_STATEMENT);
        }
    }

    protected boolean isZero() {
        return positiveNumber == ZERO_VALUE;
    }

    protected abstract boolean enableZero();

    public void increase() {
        positiveNumber++;
    }

    public void decrease() {
        positiveNumber--;
    }

    public int number() {
        return positiveNumber;
    }
}
