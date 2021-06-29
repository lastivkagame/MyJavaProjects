package MyClasses;

public class Ukulele extends MusicalInstrument{

    public Ukulele() {
        super("ukulele");
    }

    @Override
    public void Sound() {
        System.out.println("uuuuuuuuuuuuu");
    }

    @Override
    public void Show() {
        System.out.println("ukulele");
    }

    @Override
    public void Desc() {
        System.out.println("ukulele description");
    }

    @Override
    public void Histoty() {
        System.out.println("history of ukulele");
    }
}
