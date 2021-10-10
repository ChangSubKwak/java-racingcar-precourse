package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Cars;

class CarsTest {
    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(Cars.of("chang", "pobi", "crong")).isInstanceOf(Cars.class);
    }

}
