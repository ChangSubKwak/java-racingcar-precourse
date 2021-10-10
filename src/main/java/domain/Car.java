package domain;

public class Car {
    public static final int INITIAL_POSITION = 0;

    private final CarName carName;
    private CarPosition carPosition;

    private Car(String carName) {
        this.carName = CarName.from(carName);
        this.carPosition = CarPosition.from(INITIAL_POSITION);
    }

    private Car(String carName, int carPosition) {
        this(carName);
        this.carPosition = CarPosition.from(carPosition);
    }

    public static Car from(String carName) {
        return new Car(carName);
    }

    public static Car of(String carName, int carPosition) {
        return new Car(carName, carPosition);
    }

    public void forward(/* MovableStrategy movableStrategy */) {
        // 전략 패턴 구현 필요
        carPosition = CarPosition.from(carPosition.positiveNumber() + 1);
    }

    public CarPosition position() {
        return carPosition;
    }
}
