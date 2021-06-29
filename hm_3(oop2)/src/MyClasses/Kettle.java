package MyClasses;

public class Kettle extends Device{

    public Kettle() {
        super("kettle");
    }

    @Override
    public void Sound() {
        System.out.println("Tooo oooo ...");
    }

    @Override
    public void Show() {
        System.out.println("I'm kettle");
    }

    @Override
    public void Desc() {
        System.out.println("You use kettle if you need a warm water");
    }
}
