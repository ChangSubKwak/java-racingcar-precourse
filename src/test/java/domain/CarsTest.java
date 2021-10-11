package domain;

import static fixture.Fixture.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import strategy.AlwaysMovableStrategy;
import strategy.MovableStrategy;
import strategy.NoMovableStrategy;

class CarsTest {
    private static Stream<Arguments> forwardCarsTest() {
        return Stream.of(
            Arguments.of(AlwaysMovableStrategy.newInstance(), 0, 1),
            Arguments.of(NoMovableStrategy.newInstance(), 0, 0)
        );
    }

    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(Cars.of("chang", "pobi", "crong")).isInstanceOf(Cars.class);
    }

    @DisplayName("자동차의 이름배열 값이 null로 입력받으면 예외가 발생한다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> Cars.from(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Cars.of((String[])null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Cars.of((Car[])null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 이름값이 중복되면 예외가 발생한다.")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> Cars.from(Arrays.asList("chang", "pobi", "crong", "chang"))).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("자동차 목록에 있는 전부를 이동하면, 전략에 따른 이동패턴으로 이동하며, 위치가 증가 또는 그대로이다.")
    @ParameterizedTest(name = "움직이기 전 [{1}], 움직인 후 [{2}]")
    @MethodSource
    void forwardCarsTest(MovableStrategy movableStrategy, int asisPosition, int tobePosition) {
        Cars cars = testCars();
        cars.carDtos()
            .forEach(carDto -> assertThat(carDto.getCarPosition()).isEqualTo(asisPosition));
        cars.forwardCars(movableStrategy);
        cars.carDtos()
            .forEach(carDto -> assertThat(carDto.getCarPosition()).isEqualTo(tobePosition));
    }

    @DisplayName("자동차 목록에 있는 자동차를 점진적으로 이동하면, 이동마다 일등 그룹(승리)에 이동한 자동차가 포함된다.")
    @Test
    void firstGroupTest() {
        Cars cars = Cars.of(changCar, pobiCar, crongCar);

        changCar.forward(AlwaysMovableStrategy.newInstance());
        assertThat(cars.firstGroup()).containsExactly(changCar.carName());

        pobiCar.forward(AlwaysMovableStrategy.newInstance());
        assertThat(cars.firstGroup()).containsExactly(changCar.carName(), pobiCar.carName());

        crongCar.forward(AlwaysMovableStrategy.newInstance());
        assertThat(cars.firstGroup()).containsExactly(changCar.carName(), pobiCar.carName(), crongCar.carName());
    }
}
