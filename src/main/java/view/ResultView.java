package view;

import java.util.List;

import dto.CarDto;

public class ResultView {
    private static final String OUTPUT_GAME_RESULT_STATEMENT = "실행 결과";
    private static final String OUTPUT_CAR_NAME_FORMAT = "%s : ";
    private static final String OUTPUT_FORWARD_PROGRESS_UNIT = "-";
    private static final String OUTPUT_FIRST_CAR_SEPERATOR = ",";
    private static final String OUTPUT_FIRST_GROUP_STATEMENT = "최종 우승자는 %s 입니다.";
    private static final String OUTPUT_ERROR_MESSAGE = "[ERROR] %s 다시 입력해주세요.";

    public void outputGameResultStatement() {
        System.out.println(OUTPUT_GAME_RESULT_STATEMENT);
    }

    public void outputCars(List<CarDto> carDtos) {
        for (CarDto carDto : carDtos) {
            outputCar(carDto.getCarName(), carDto.getCarPosition());
        }
        System.out.print(System.lineSeparator());
    }

    private void outputCar(String carName, int carPosition) {
        System.out.printf(OUTPUT_CAR_NAME_FORMAT, carName);
        for (int i = 0; i < carPosition; i++) {
            System.out.print(OUTPUT_FORWARD_PROGRESS_UNIT);
        }
        System.out.print(System.lineSeparator());
    }

    public void outputFirstGroup(List<String> firstGroup) {
        StringBuilder firstGroupString = new StringBuilder();
        for (String s : firstGroup) {
            firstGroupString.append(s);
            firstGroupString.append(OUTPUT_FIRST_CAR_SEPERATOR);
        }
        System.out.printf(OUTPUT_FIRST_GROUP_STATEMENT, firstGroupString.substring(0, firstGroupString.length() - 1));
        System.out.print(System.lineSeparator());
    }

    public void outputErrorMessage(String message) {
        System.out.printf(OUTPUT_ERROR_MESSAGE, message);
        System.out.print(System.lineSeparator());
    }
}
