package strategy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import strategy.AlwaysMovableStrategy;
import strategy.EveryNTimesMovableStrategy;
import strategy.MovableStrategy;
import strategy.NoMovableStrategy;

class NoMovableStrategyTest {
    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(NoMovableStrategy.newInstance()).isInstanceOf(NoMovableStrategy.class);
    }

    @DisplayName("항상 정지하는 전략울 선택하면 움직임 여부는 항상 거짓이다.")
    @Test
    void isMovableTest() {
        MovableStrategy movableStrategy = NoMovableStrategy.newInstance();
        assertThat(movableStrategy.isMovable()).isFalse();
    }
}
