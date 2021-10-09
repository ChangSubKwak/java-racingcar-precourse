package domain;

public abstract class PositiveNumber {
    private static final String POSITIVE_NUMBER_MUST_NOT_BE_NEGATIVE_EXCEPTION_STATEMENT = "음수값은 올바르지 않습니다.";
    private static final String MUST_NOT_BE_ZERO_EXCEPTION_STATEMENT = "값이 0이 되면 안됩니다.";

    int positiveNumber;

    protected PositiveNumber(int positiveNumber) {
        validate(positiveNumber);
        this.positiveNumber = positiveNumber;
    }

    private void validate(int positiveNumber) {
        if (positiveNumber < 0) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_MUST_NOT_BE_NEGATIVE_EXCEPTION_STATEMENT);
        }

        if (isZero()) {
            throw new IllegalArgumentException(MUST_NOT_BE_ZERO_EXCEPTION_STATEMENT);
        }
    }

    private boolean isZero() {
        return !enableZero() && positiveNumber == 0;
    }

    protected abstract boolean enableZero();
}
