package MyClasses;

public class Tiger extends Animal{
    public Tiger() {
        super("Jonth", "eat meat", "run", "white and orange");
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", type_eat='" + type_eat + '\'' +
                ", type_move='" + type_move + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
