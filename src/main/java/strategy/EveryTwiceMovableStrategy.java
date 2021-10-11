package strategy;

public class EveryTwiceMovableStrategy implements MovableStrategy {
    private static boolean isMovable = true;

    private EveryTwiceMovableStrategy() {
    }

    public static EveryTwiceMovableStrategy newInstance() {
        return new EveryTwiceMovableStrategy();
    }

    public boolean isMovable() {
        isMovable = !isMovable;
        return isMovable;
    }
}
