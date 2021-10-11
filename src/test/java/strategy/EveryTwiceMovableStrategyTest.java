package strategy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EveryNTimesMovableStrategyTest {
    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(EveryTwiceMovableStrategy.newInstance()).isInstanceOf(EveryTwiceMovableStrategy.class);
    }


    @DisplayName("N번마다 움직일 수 있는 전략을 선택하면 움직임 여부는 N번마다 항상 참이다.")
    @Test
    void isMovableTest() {
        MovableStrategy movableStrategy = EveryTwiceMovableStrategy.newInstance();
        assertThat(movableStrategy.isMovable()).isFalse();
        assertThat(movableStrategy.isMovable()).isTrue();
    }
}
