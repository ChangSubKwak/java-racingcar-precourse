package domain;

public class CarPosition extends PositiveNumber {
    private CarPosition(int carPosition) {
        super(carPosition);
    }

    public static CarPosition from(int carPosition) {
        return new CarPosition(carPosition);
    }

    protected boolean enableZero() {
        return true;
    }

    public int carPosition() {
        return positiveNumber();
    }
}
