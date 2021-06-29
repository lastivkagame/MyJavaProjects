package MyClasses;

public class Cello extends MusicalInstrument{

    public Cello() {
        super("cello");
    }

    @Override
    public void Sound() {
        System.out.println("ccccccccccc");
    }

    @Override
    public void Show() {
        System.out.println("cello");
    }

    @Override
    public void Desc() {
        System.out.println("cello description");
    }

    @Override
    public void Histoty() {
        System.out.println("history of cello");
    }
}
