package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {
    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(CarName.from("chang")).isInstanceOf(CarName.class);
    }

    @DisplayName("자동차의 이름이 5자 초과하면 예외가 발생한다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> CarName.from("changsubkwak")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 이름이 null 또는 빈문자이면 예외가 발생한다.")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> CarName.from(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CarName.from("")).isInstanceOf(IllegalArgumentException.class);
    }
}
