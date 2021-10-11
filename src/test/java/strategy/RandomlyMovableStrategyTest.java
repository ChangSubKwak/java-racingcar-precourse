package strategy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomlyMovableStrategyTest {
    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(RandomlyMovableStrategy.newInstance()).isInstanceOf(RandomlyMovableStrategy.class);
        assertThat(RandomlyMovableStrategy.of(0, 9)).isInstanceOf(RandomlyMovableStrategy.class);
    }

    @DisplayName("랜덤 전략을 선택하면, 주어진 랜덤값이 0과 3사이이면 경우 이동여부 값은 참, 4와 9사이이면 이동여부가 값이 거짓이다.")
    @Test
    void isMovableTest() {
        assertThat(RandomlyMovableStrategy.of(3, 3).isMovable()).isFalse();
        assertThat(RandomlyMovableStrategy.of(4, 4).isMovable()).isTrue();
    }

}
