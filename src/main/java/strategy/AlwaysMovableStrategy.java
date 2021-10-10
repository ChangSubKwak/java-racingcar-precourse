package strategy;

public class AlwaysMovableStrategy implements MovableStrategy {
    private AlwaysMovableStrategy() {}

    public static AlwaysMovableStrategy newInstance() {
        return new AlwaysMovableStrategy();
    }

    public boolean isMovable() {
        return true;
    }
}
