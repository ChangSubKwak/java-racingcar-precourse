package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Car;
import strategy.AlwaysMovableStrategy;
import strategy.EveryNTimesMovableStrategy;
import strategy.MovableStrategy;

class EveryNTimesMovableStrategyTest {
    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(EveryNTimesMovableStrategy.from(2)).isInstanceOf(EveryNTimesMovableStrategy.class);
        assertThat(EveryNTimesMovableStrategy.of(2, 0)).isInstanceOf(EveryNTimesMovableStrategy.class);
    }


    @DisplayName("N번마다 움직일 수 있는 전략을 선택하면 움직임 여부는 N번마다 항상 참이다.")
    @Test
    void isMovableTest() {
        MovableStrategy movableStrategy = EveryNTimesMovableStrategy.from(2);
        assertThat(movableStrategy.isMovable()).isFalse();
        assertThat(movableStrategy.isMovable()).isTrue();
    }

    @DisplayName("움직임 시도회수 주기가 0보다 작으면 예외가 발생한다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> EveryNTimesMovableStrategy.from(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("움직임 시도회수가 음수이면 예외가 발생한다.")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> EveryNTimesMovableStrategy.of(2, -1)).isInstanceOf(IllegalArgumentException.class);
    }
}
