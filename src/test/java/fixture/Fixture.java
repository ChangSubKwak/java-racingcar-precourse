package fixture;

import domain.Car;
import domain.Cars;

public class Fixture {
    public static final Car changCar = Car.from("chang");
    public static final Car pobiCar = Car.from("pobi");
    public static final Car crongCar = Car.from("crong");

    public static Cars testCars() {
        return Cars.of("chang", "pobi", "crong", "honux");
    }
}
