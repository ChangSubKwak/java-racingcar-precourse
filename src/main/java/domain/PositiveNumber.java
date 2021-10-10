package domain;

import java.util.Objects;

public abstract class PositiveNumber {
    private static final String POSITIVE_NUMBER_MUST_NOT_BE_NEGATIVE_EXCEPTION_STATEMENT = "음수값은 올바르지 않습니다.";
    private static final String MUST_NOT_BE_ZERO_EXCEPTION_STATEMENT = "값이 0이 되면 안됩니다.";
    private static final int ZERO_VALUE = 0;

    private final int positiveNumber;

    protected PositiveNumber(int positiveNumber) {
        validate(positiveNumber);
        this.positiveNumber = positiveNumber;
    }

    private void validate(int positiveNumber) {
        if (positiveNumber < ZERO_VALUE) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_MUST_NOT_BE_NEGATIVE_EXCEPTION_STATEMENT);
        }

        if (isZero(positiveNumber)) {
            throw new IllegalArgumentException(MUST_NOT_BE_ZERO_EXCEPTION_STATEMENT);
        }
    }

    protected int positiveNumber() {
        return positiveNumber;
    }

    private boolean isZero(int positiveNumber) {
        return !enableZero() && positiveNumber == ZERO_VALUE;
    }

    protected abstract boolean enableZero();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PositiveNumber))
            return false;
        PositiveNumber that = (PositiveNumber)o;
        return positiveNumber == that.positiveNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positiveNumber);
    }
}
