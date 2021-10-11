package dto;

import static fixture.Fixture.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDtoTest {
    CarDto carDto;

    @BeforeEach
    void setUp() {
        carDto = CarDto.from(changCar);
    }

    @DisplayName("정적팩터리 메서드를 이용하여 객체를 생성하면 객체가 생성된다.")
    @Test
    void createTest() {
        assertThat(CarDto.from(changCar)).isInstanceOf(CarDto.class);
    }

    @DisplayName("자동차 이름을 얻는 메서드를 호출하면, 원래의 Car 객체의 자동차 이름을 얻는다.")
    @Test
    void getCarNameTest() {

        assertThat(carDto.getCarName()).isEqualTo(changCar.carName());
    }

    @DisplayName("자동차 위치를 얻는 메서드를 호출하면, 원래의 Car 객체의 자동차 위치를 얻는다.")
    @Test
    void getCarPositionTest() {
        CarDto carDto = CarDto.from(changCar);
        assertThat(carDto.getCarPosition()).isEqualTo(changCar.carPosition());
    }
}
