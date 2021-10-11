package dto;

import domain.Car;

public class CarDto {
    private final String carName;
    private final int carPosition;

    private CarDto(Car car) {
        this.carName = car.carName();
        this.carPosition = car.carPosition();
    }

    public static CarDto from(Car car) {
        return new CarDto(car);
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
