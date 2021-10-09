package domain;

public class CarName {
    private static final String CAR_NAME_OVER_FIVE_LENGTH_EXCEPTION_STATEMENT = "자동차의 이름이 5자를 초과하였습니다.";

    private String carName;

    private CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    public static CarName from(String carName) {
        return new CarName(carName);
    }

    private void validate(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_OVER_FIVE_LENGTH_EXCEPTION_STATEMENT);
        }
    }

}
