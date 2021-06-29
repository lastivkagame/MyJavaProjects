package MyClasses;

public class Microwave extends Device{

    public Microwave() {
        super("microwave");
    }

    @Override
    public void Sound() {
        System.out.println("piiic ... nothing ... piiiic");
    }

    @Override
    public void Show() {
        System.out.println("I'm microwave");
    }

    @Override
    public void Desc() {
        System.out.println("You use microwave if you need a quickly warm eat");
    }
}
