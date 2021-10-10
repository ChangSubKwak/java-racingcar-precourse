package strategy;

public class NoMovableStrategy implements MovableStrategy {
    private NoMovableStrategy() {}

    public static NoMovableStrategy newInstance() {
        return new NoMovableStrategy();
    }

    public boolean isMovable() {
        return false;
    }
}
