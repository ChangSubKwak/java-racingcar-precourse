package domain;

import java.util.Objects;

public abstract class PositiveNumber implements Comparable<PositiveNumber> {
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

    @Override
    public int compareTo(PositiveNumber o) {
        return o.positiveNumber - positiveNumber;
    }

    protected int positiveNumber() {
        return positiveNumber;
    }
}
