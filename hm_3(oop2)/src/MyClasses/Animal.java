package MyClasses;

public class Animal {
    public String name;
    public String type_eat;
    public String type_move;
    public String color;

    public Animal(String name, String type_eat, String type_move, String color) {
        this.name = name;
        this.type_eat = type_eat;
        this.type_move = type_move;
        this.color = color;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType_eat() {
        return type_eat;
    }

    public void setType_eat(String type_eat) {
        this.type_eat = type_eat;
    }

    public String getType_move() {
        return type_move;
    }

    public void setType_move(String type_move) {
        this.type_move = type_move;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type_eat='" + type_eat + '\'' +
                ", type_move='" + type_move + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
