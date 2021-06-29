package MyClasses;

public abstract class Device {
    public String name;

    public Device(String name) {
        this.name = name;
    }

    public abstract void Sound();
   /* {
        System.out.println("  ...  ");
    }*/

    public abstract void Show();
    /*{
        System.out.println("I'm device");
    }*/

    public abstract void Desc();
    /*{
        System.out.println("I'm description for device");
    }*/
}
