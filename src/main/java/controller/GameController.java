package controller;

import java.util.Optional;

import domain.Cars;
import domain.GameTryCount;
import strategy.RandomlyMovableStrategy;
import view.InputView;
import view.ResultView;

public class GameController {
    private GameController() {
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
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
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
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        try {
            return Optional.of(GameTryCount.from(inputView.inputGameTryCount()));
        } catch (IllegalArgumentException e) {
            resultView.outputErrorMessage(e.getMessage());
            return Optional.empty();
        }
    }

    public void outputResult(Cars cars, GameTryCount gameTryCount) {
        ResultView resultView = new ResultView();
        resultView.outputGameResultStatement();
        for (int i = 0; i < gameTryCount.number(); i++) {
            cars.forwardCars(RandomlyMovableStrategy.newInstance());
            resultView.outputCars(cars.carDtos());
        }
        resultView.outputFirstGroup(cars.firstGroup());
    }
}
