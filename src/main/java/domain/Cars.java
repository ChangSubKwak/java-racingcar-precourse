package domain;

import java.util.ArrayList;
import java.util.List;

import dto.CarDto;
import strategy.MovableStrategy;

public class Cars {
    private List<Car> cars;

    private Cars(String... names) {
        init();
        for (String name : names) {
            Car car = Car.from(name);
            cars.add(car);
        }
    }

    private Cars(Car... cars) {
        init();
        for (Car car : cars) {
            this.cars.add(car);
        }
    }

    public static Cars of(String... names) {
        return new Cars(names);
    }

    public static Cars of(Car... cars) {
        return new Cars(cars);
    }

    public static Cars from(List<String> cars) {
        String[] carsString = new String[cars.size()];
        return new Cars(cars.toArray(carsString));
    }

    private void init() {
        cars = new ArrayList<>();
    }

    public void forwardCars(MovableStrategy movableStrategy) {
        for (Car car : cars) {
            car.forward(movableStrategy);
        }
    }

    public List<String> firstGroup() {
        int firstPosition = getFirstPosition();
        List<String> names = new ArrayList<>();

        for (Car car : cars) {
            addToFirstGroup(firstPosition, car, names);
        }
        return names;
    }

    private int getFirstPosition() {
        int firstPosition = 0;
        for (Car car : cars) {
            if (firstPosition < car.carPosition()) {
                firstPosition = car.carPosition();
            }
        }
        return firstPosition;
    }

    private void addToFirstGroup(int firstPosition, Car targetCar, List<String> names) {
        if (firstPosition == targetCar.carPosition()) {
            names.add(targetCar.carName());
        }
    }

    public List<CarDto> carDtos() {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            carDtos.add(CarDto.from(car));
        }
        return carDtos;
    }
}
