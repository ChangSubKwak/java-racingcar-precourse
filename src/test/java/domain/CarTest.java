package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fixture.Fixture;
import strategy.AlwaysMovableStrategy;
import strategy.EveryTwiceMovableStrategy;
import strategy.NoMovableStrategy;

class CarTest {
    Car changCar;

    @BeforeEach
    void setUp() {
        changCar = Car.from(Fixture.changCar.carName());
    }

    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(Car.from("chang")).isInstanceOf(Car.class);
    }

    @DisplayName("자동차의 이름이 5자를 넘으면 예외가 발생한다.")
    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> Car.from("changsub")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("항상움직임 전략으로 전진하면, 자동차가 한칸 이동한다.")
    @Test
    void forwardTest1() {
        changCar.forward(AlwaysMovableStrategy.newInstance());
        assertThat(changCar.carPosition()).isEqualTo(1);
    }

    @DisplayName("정지 전략으로 전진하면, 자동차는 현재 자리에 그대로 있는다.")
    @Test
    void forwardTest2() {
        changCar.forward(NoMovableStrategy.newInstance());
        assertThat(changCar.carPosition()).isEqualTo(0);
    }

    @DisplayName("2번마다 움직임 전략으로 전진하면, 첫번째는 그대로 있으며, 두번째는 자동차가 한칸 이동한다.")
    @Test
    void forwardTest3() {
        changCar.forward(EveryTwiceMovableStrategy.newInstance());
        assertThat(changCar.carPosition()).isEqualTo(0);

        changCar.forward(EveryTwiceMovableStrategy.newInstance());
        assertThat(changCar.carPosition()).isEqualTo(1);
    }
}
