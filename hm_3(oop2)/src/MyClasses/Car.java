package MyClasses;

public class Car extends Device{

    public Car() {
        super("car");
    }

    @Override
    public void Sound() {
        System.out.println("Br rrrr... broom");
    }

    @Override
    public void Show() {
        System.out.println("I'm car");
    }

    @Override
    public void Desc() {
        System.out.println("You use car if you need a change your location quickly");
    }
}
