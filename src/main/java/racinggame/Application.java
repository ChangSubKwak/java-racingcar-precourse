package racinggame;

import controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = GameController.newInstance();
        gameController.outputResult(gameController.inputCars(), gameController.inputGameTryCount());
    }
}
