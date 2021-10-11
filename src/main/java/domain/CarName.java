package domain;

import java.util.Objects;

public class CarName {
    private static final String CAR_NAME_OVER_FIVE_LENGTH_EXCEPTION_STATEMENT = "자동차의 이름이 5자를 초과하였습니다.";
    private static final String CAR_NAME_IS_NULL_OR_EMPTY_EXCEPTION_STATEMENT = "자동차의 이름이 null 또는 빈문자 입니다.";
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String carName;

    private CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    public static CarName from(String carName) {
        return new CarName(carName);
    }

    private void validate(String carName) {
        if (Objects.isNull(carName) || carName.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_IS_NULL_OR_EMPTY_EXCEPTION_STATEMENT);
        }

        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_OVER_FIVE_LENGTH_EXCEPTION_STATEMENT);
        }
    }

    public String carName() {
        return carName;
    }
}
