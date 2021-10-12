package controller;

import java.util.Optional;

import domain.Cars;
import domain.GameTryCount;
import strategy.RandomlyMovableStrategy;
import view.InputView;
import view.ResultView;

public class GameController {
    InputView inputView;
    ResultView resultView;

    private GameController() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public static GameController newInstance() {
        return new GameController();
    }

    public Cars inputCars() {
        Optional<Cars> cars = Optional.empty();
        while (!cars.isPresent()) {
            cars = generateCarsFromInputCarNames();
        }
        return cars.get();
    }

    private Optional<Cars> generateCarsFromInputCarNames() {
        try {
            return Optional.of(Cars.from(inputView.inputCarNames()));
        } catch (IllegalArgumentException e) {
            resultView.outputErrorMessage(e.getMessage());
            return Optional.empty();
        }
    }

    public GameTryCount inputGameTryCount() {
        Optional<GameTryCount> gameTryCount = Optional.empty();
        while (!gameTryCount.isPresent()) {
            gameTryCount = generateGameTryCountFromInputCarNames();
        }
        return gameTryCount.get();
    }

    private Optional<GameTryCount> generateGameTryCountFromInputCarNames() {

        try {
            return Optional.of(GameTryCount.from(inputView.inputGameTryCount()));
        } catch (IllegalArgumentException e) {
            resultView.outputErrorMessage(e.getMessage());
            return Optional.empty();
        }
    }

    public void outputResult(Cars cars, GameTryCount gameTryCount) {
        resultView.outputGameResultStatement();
        for (int i = 0; i < gameTryCount.number(); i++) {
            cars.forwardCars(RandomlyMovableStrategy.newInstance());
            resultView.outputCars(cars.carDtos());
        }
        resultView.outputFirstGroup(cars.firstGroup());
    }
}
