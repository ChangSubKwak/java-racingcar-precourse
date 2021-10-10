package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(String... names) {
        cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(Car.from(names[i]));
        }
    }

    public static Cars of(String... names) {
        return new Cars(names);
    }
}
