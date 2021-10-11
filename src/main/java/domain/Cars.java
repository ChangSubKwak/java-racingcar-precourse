package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import dto.CarDto;
import strategy.MovableStrategy;

public class Cars {
    private static final String CAR_NAME_ARRAY_IS_NULL_OR_EMPTY_EXCEPTION_STATEMENT = "자동차의 이름 배열이 null 입니다.";
    private static final String CAR_NAME_DUPLICATION_EXCEPTION_STATEMENT = "자동차의 이름이 중복됩니다.";

    private List<Car> cars;

    private Cars(String... names) {
        validateString(names);
        init();
        for (String name : names) {
            Car car = Car.from(name);
            cars.add(car);
        }
    }

    public static Cars of(String... names) {
        return new Cars(names);
    }

    public static Cars of(Car... cars) {
        validateObject(cars);
        String[] names = new String[cars.length];
        for (int i = 0; i < cars.length; i++) {
            names[i] = cars[i].carName();
        }
        return new Cars(names);
    }

    public static Cars from(List<String> cars) {
        validateList(cars);
        String[] carsString = new String[cars.size()];
        return new Cars(cars.toArray(carsString));
    }

    private static void validateString(String[] names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(CAR_NAME_ARRAY_IS_NULL_OR_EMPTY_EXCEPTION_STATEMENT);
        }

        Set<String> namesSet = new HashSet<>(Arrays.asList(names));
        if (namesSet.size() != names.length) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_EXCEPTION_STATEMENT);
        }
    }

    private static void validateObject(Car[] cars) {
        if (Objects.isNull(cars)) {
            throw new IllegalArgumentException(CAR_NAME_ARRAY_IS_NULL_OR_EMPTY_EXCEPTION_STATEMENT);
        }

        Set<String> namesSet = new HashSet<>();
        for (Car car : cars) {
            namesSet.add(car.carName());
        }
        if (namesSet.size() != cars.length) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_EXCEPTION_STATEMENT);
        }
    }

    private static void validateList(List<String> cars) {
        if (Objects.isNull(cars)) {
            throw new IllegalArgumentException(CAR_NAME_ARRAY_IS_NULL_OR_EMPTY_EXCEPTION_STATEMENT);
        }

        Set<String> namesSet = new HashSet<>(cars);
        if (namesSet.size() != cars.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_EXCEPTION_STATEMENT);
        }
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
