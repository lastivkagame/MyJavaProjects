package MyClasses;

public class Kengaroo extends Animal{
    public Kengaroo() {
        super("Michael", "eat plante", "jump and swimming", "orange and beige");
    }

    @Override
    public String toString() {
        return "Kengaroo{" +
                "name='" + name + '\'' +
                ", type_eat='" + type_eat + '\'' +
                ", type_move='" + type_move + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
