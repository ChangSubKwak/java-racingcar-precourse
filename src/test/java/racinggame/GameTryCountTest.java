package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.CarPosition;
import domain.GameTryCount;

class GameTryCountTest {
    private static final int GAME_TRY_COUNT_MIN_COUNT = 1;

    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(GameTryCount.from(GAME_TRY_COUNT_MIN_COUNT)).isInstanceOf(GameTryCount.class);
    }

    @DisplayName("음수값으로 객체 생성시 예외가 발생한다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> GameTryCount.from(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 진행 횟수가 0이되면 예외가 발생한다.")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> GameTryCount.from(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
