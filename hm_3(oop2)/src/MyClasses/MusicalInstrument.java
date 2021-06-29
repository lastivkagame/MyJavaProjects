package MyClasses;

public abstract class MusicalInstrument {
    public String name;

    public MusicalInstrument(String name) {
        this.name = name;
    }

    public abstract void Sound();

    public abstract void Show();

    public abstract void Desc();

    public abstract void Histoty();
}
