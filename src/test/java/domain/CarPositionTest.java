package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.CarPosition;

class CarPositionTest {
    private static final int CAR_POSITION_INITIAL_POSITION = 0;

    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(CarPosition.from(CAR_POSITION_INITIAL_POSITION)).isInstanceOf(CarPosition.class);
    }

    @DisplayName("음수값으로 객체 생성시 예외가 발생한다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> CarPosition.from(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
