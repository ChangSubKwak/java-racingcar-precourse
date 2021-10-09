package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.CarName;

class CarNameTest {
    CarName carName;

    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(carName.from("chang")).isInstanceOf(CarName.class);
    }

    @DisplayName("자동차의 이름이 5자 초과하면 예외가 발생한다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> carName.from("changsubkwak")).isInstanceOf(IllegalArgumentException.class);
    }
}
