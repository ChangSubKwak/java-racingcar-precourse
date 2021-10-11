package strategy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AlwaysMovableStrategyTest {
    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(AlwaysMovableStrategy.newInstance()).isInstanceOf(AlwaysMovableStrategy.class);
    }

    @DisplayName("항상 움직일 수 있는 전략울 선택하면 움직임 여부는 항상 참이다.")
    @Test
    void isMovableTest() {
        MovableStrategy movableStrategy = AlwaysMovableStrategy.newInstance();
        assertThat(movableStrategy.isMovable()).isTrue();
    }
}
