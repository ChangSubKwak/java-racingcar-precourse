package domain;

import java.util.Objects;

import strategy.MovableStrategy;

public class Car implements Comparable<Car> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Car))
            return false;
        Car car = (Car)o;
        return carName.equals(car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    @Override
    public int compareTo(Car o) {
        return carPosition.compareTo(o.carPosition);
    }

    public String carName() {
        return carName.carName();
    }

    public int carPosition() {
        return carPosition.carPosition();
    }
}
