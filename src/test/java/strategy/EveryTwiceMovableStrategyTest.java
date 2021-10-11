package strategy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EveryTwiceMovableStrategyTest {
    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(EveryTwiceMovableStrategy.newInstance()).isInstanceOf(EveryTwiceMovableStrategy.class);
    }

    @DisplayName("2번마다 움직일 수 있는 전략을 이용하여 움직임여부 호출횟수를 기준으로, 2번마다 항상 참이다.")
    @Test
    void isMovableTest() {
        MovableStrategy movableStrategy = EveryTwiceMovableStrategy.newInstance();
        assertThat(movableStrategy.isMovable()).isFalse();
        assertThat(movableStrategy.isMovable()).isTrue();
    }
}
