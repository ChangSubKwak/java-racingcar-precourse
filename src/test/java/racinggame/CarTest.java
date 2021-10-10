package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Car;

class CarTest {
    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(Car.from("chang")).isInstanceOf(Car.class);
    }

    @DisplayName("자동차의 이름이 5자를 넘으면 예외가 발생한다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> Car.from("chang1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void forwardTest() {
        Car car = Car.of("chang", Car.INITIAL_POSITION);
        car.forward();
        Car expected = Car.of("pobi", 1);
        assertThat(car.position()).isEqualTo(expected.position());
    }
}
