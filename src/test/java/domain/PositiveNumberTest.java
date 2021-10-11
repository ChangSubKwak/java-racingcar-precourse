package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveNumberTest {
    @DisplayName("음수값으로 객체를 생성하면 예외가 발생한다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> new NonZeroPositiveNumber(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new EnableZeroPositiveNumber(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0값을 불허하는 객체인 NonZeroPositiveNumber를 0값으로 겍체를 생성하면 예외가 발생한다.")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> new NonZeroPositiveNumber(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0값을 허용하는 객체인 EnableZeroPositiveNumber의 0값으로 겍체를 생성한 뒤, isZero()를 호춣하면 참을 반환한다.")
    @Test
    void isZeroTest1() {
        assertThat(new EnableZeroPositiveNumber(0).isZero()).isTrue();
    }

    @DisplayName("0값을 허용하는 객체인 EnableZeroPositiveNumber의 1값으로 겍체를 생성한 뒤, isZero()를 호춣하면 거짓을 반환한다.")
    @Test
    void isZeroTest2() {
        assertThat(new EnableZeroPositiveNumber(1).isZero()).isFalse();
    }

    @DisplayName("증가 메서드를 호출하면 값이 1 증가한다.")
    @Test
    void increaseTest() {
        NonZeroPositiveNumber nonZeroPositiveNumber = new NonZeroPositiveNumber(1);
        EnableZeroPositiveNumber enableZeroPositiveNumber = new EnableZeroPositiveNumber(1);

        nonZeroPositiveNumber.increase();
        assertThat(nonZeroPositiveNumber.positiveNumber()).isEqualTo(2);

        enableZeroPositiveNumber.increase();
        assertThat(nonZeroPositiveNumber.positiveNumber()).isEqualTo(2);
    }

    @DisplayName("감소 메서드를 호출하면 값이 1 감소한다.")
    @Test
    void decreaseTest() {
        NonZeroPositiveNumber nonZeroPositiveNumber = new NonZeroPositiveNumber(1);
        EnableZeroPositiveNumber enableZeroPositiveNumber = new EnableZeroPositiveNumber(1);

        nonZeroPositiveNumber.decrease();
        assertThat(nonZeroPositiveNumber.positiveNumber()).isEqualTo(0);

        enableZeroPositiveNumber.decrease();
        assertThat(nonZeroPositiveNumber.positiveNumber()).isEqualTo(0);
    }

    static class NonZeroPositiveNumber extends PositiveNumber {
        protected NonZeroPositiveNumber(int positiveNumber) {
            super(positiveNumber);
        }

        @Override
        protected boolean enableZero() {
            return false;
        }
    }

    static class EnableZeroPositiveNumber extends PositiveNumber {
        protected EnableZeroPositiveNumber(int positiveNumber) {
            super(positiveNumber);
        }

        @Override
        protected boolean enableZero() {
            return true;
        }
    }
}
