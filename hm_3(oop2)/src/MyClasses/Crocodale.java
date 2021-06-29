package MyClasses;

public class Crocodale extends Animal{
    public Crocodale() {
        super("Mike", "eat meat", "swimming", "green");
    }

    @Override
    public String toString() {
        return "Crocodale{" +
                "name='" + name + '\'' +
                ", type_eat='" + type_eat + '\'' +
                ", type_move='" + type_move + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
