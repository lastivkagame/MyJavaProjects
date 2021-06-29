package MyClasses;

public class Steamer extends Device{

    public Steamer() {
        super("steamer");
    }

    @Override
    public void Sound() {
        System.out.println("Tyyy yyy Tyy");
    }

    @Override
    public void Show() {
        System.out.println("I'm steamer");
    }

    @Override
    public void Desc() {
        System.out.println("You use steamer if you need a move on water");
    }
}
