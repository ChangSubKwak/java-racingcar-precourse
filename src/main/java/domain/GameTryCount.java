package domain;

public class GameTryCount extends PositiveNumber {
    private GameTryCount(int gameTryCount) {
        super(gameTryCount);
    }

    public static GameTryCount from(int gameTryCount) {
        return new GameTryCount(gameTryCount);
    }

    protected boolean enableZero() {
        return false;
    }

    public boolean isGameEnd() {
        return isZero();
    }
}
