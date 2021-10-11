package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import dto.CarDto;
import strategy.MovableStrategy;

public class Cars {
    private List<Car> cars;
    private TreeSet<Car> sortedCars;

    private Cars(String... names) {
        init();
        for (int i = 0; i < names.length; i++) {
            Car car = Car.from(names[i]);
            cars.add(car);
            sortedCars.add(car);
        }
    }

    private Cars(Car... cars) {
        init();
        for (int i = 0; i < cars.length; i++) {
            this.cars.add(cars[i]);
            sortedCars.add(cars[i]);
        }
    }

    public static Cars of(String... names) {
        return new Cars(names);
    }

    public static Cars of(Car... cars) {
        return new Cars(cars);
    }

    private void init() {
        cars = new ArrayList<>();
        sortedCars = new TreeSet<>();
    }

    public void forwardCars(MovableStrategy movableStrategy) {
        for (Car car : cars) {
            car.forward(movableStrategy);
        }
    }

    public List<String> firstGroup() {
        Car firstCar = sortedCars.first();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            addToFirstGroup(firstCar, cars.get(i), names);
        }
        return names;
    }

    private void addToFirstGroup(Car firstCar, Car targetCar, List<String> names) {
        if (firstCar.isEqualPosition(targetCar)) {
            names.add(targetCar.carName());
        }
    }

    public List<CarDto> carDtos() {
        List<CarDto> carDtos = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            carDtos.add(CarDto.from(cars.get(i)));
        }
        return carDtos;
    }
}
