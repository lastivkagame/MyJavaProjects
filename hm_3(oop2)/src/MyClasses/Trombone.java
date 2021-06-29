package MyClasses;

public class Trombone extends MusicalInstrument{

    public Trombone() {
        super("trombone");
    }

    @Override
    public void Sound() {
        System.out.println("tttttttttttt");
    }

    @Override
    public void Show() {
        System.out.println("trombone");
    }

    @Override
    public void Desc() {
        System.out.println("trombone description");
    }

    @Override
    public void Histoty() {
        System.out.println("history of trombone");
    }
}
