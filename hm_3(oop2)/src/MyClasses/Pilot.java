package MyClasses;

public class Pilot extends Human{
    public String InfoAboutPilot;

    //Constructors
    public Pilot(String name, String nationality, int age, String infoAboutPilot) {
        super(name, nationality, age);
        InfoAboutPilot = infoAboutPilot;
    }

    public Pilot(String infoAboutPilot) {
        InfoAboutPilot = infoAboutPilot;
    }

    public Pilot() {
    }

    public String getInfoAboutPilot() {
        return InfoAboutPilot;
    }

    public void setInfoAboutPilot(String infoAboutPilot) {
        InfoAboutPilot = infoAboutPilot;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", InfoAboutPilot='" + InfoAboutPilot + '\'' +
                '}';
    }
}