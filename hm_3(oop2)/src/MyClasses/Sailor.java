package MyClasses;

public class Sailor extends Human{
    public String InfoAboutSailor;

    //Constructors
    public Sailor(String name, String nationality, int age, String infoAboutSailor) {
        super(name, nationality, age);
        InfoAboutSailor = infoAboutSailor;
    }

    public Sailor(String infoAboutSailor) {
        InfoAboutSailor = infoAboutSailor;
    }

    public Sailor() {
    }

    public String getInfoAboutSailor() {
        return InfoAboutSailor;
    }

    public void setInfoAboutPilot(String infoAboutSailor) {
        InfoAboutSailor = infoAboutSailor;
    }

    @Override
    public String toString() {
        return "Sailor{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", InfoAboutSailor='" + InfoAboutSailor + '\'' +
                '}';
    }
}
