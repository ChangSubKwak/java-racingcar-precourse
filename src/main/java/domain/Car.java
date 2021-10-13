package domain;

import strategy.MovableStrategy;

public class Car {
    public static final int INITIAL_POSITION = 0;

    private final CarName carName;
    private final CarPosition carPosition;

    private Car(String carName) {
        this.carName = CarName.from(carName);
        this.carPosition = CarPosition.from(INITIAL_POSITION);
    }

    public static Car from(String carName) {
        return new Car(carName);
    }

    public void forward(MovableStrategy movableStrategy) {
        if (movableStrategy.isMovable()) {
            carPosition.increase();
        }
    }

    public String carName() {
        return carName.carName();
    }

    public int carPosition() {
        return carPosition.carPosition();
    }
}
