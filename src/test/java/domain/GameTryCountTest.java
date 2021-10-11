package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTryCountTest {
    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(GameTryCount.from(1)).isInstanceOf(GameTryCount.class);
    }

    @DisplayName("음수값으로 객체 생성시 예외가 발생한다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> GameTryCount.from(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 진행 횟수를 0으로 초기화하면 예외가 발생한다.")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> GameTryCount.from(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 진행 횟수가 0이되면 게임 종료 여부를 참으로 반환한다.")
    @Test
    void isGameEndTest1() {
        GameTryCount gameTryCount = GameTryCount.from(1);
        gameTryCount.decrease();
        assertThat(gameTryCount.isGameEnd()).isTrue();
    }

    @DisplayName("게임 진행 횟수가 0이 아니면 게임 종료 여부를 거짓으로 반환한다.")
    @Test
    void isGameEndTest2() {
        GameTryCount gameTryCount = GameTryCount.from(1);
        assertThat(gameTryCount.isGameEnd()).isFalse();
    }
}
