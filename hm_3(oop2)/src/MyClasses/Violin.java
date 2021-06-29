package MyClasses;

public class Violin extends MusicalInstrument{

    public Violin() {
        super("violin");
    }

    @Override
    public void Sound() {
        System.out.println("vvvvvvvvvv");
    }

    @Override
    public void Show() {
        System.out.println("violin");
    }

    @Override
    public void Desc() {
        System.out.println("violin description");
    }

    @Override
    public void Histoty() {
        System.out.println("history of violon");
    }
}
