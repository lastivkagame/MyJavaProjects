package MyClasses;

public class Builder extends Human{
    public String InfoAboutBuilder;

    //Constructors
    public Builder(String name, String nationality, int age, String infoAboutBuilder) {
        super(name, nationality, age);
        InfoAboutBuilder = infoAboutBuilder;
    }

    public Builder(String infoAboutBuilder) {
        InfoAboutBuilder = infoAboutBuilder;
    }

    public Builder() {
    }

    public String getInfoAboutBuilder() {
        return InfoAboutBuilder;
    }

    public void setInfoAboutBuilder(String infoAboutBuilder) {
        InfoAboutBuilder = infoAboutBuilder;
    }

    @Override
    public String toString() {
        return "Builder{ " +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age + '\'' +
                ", infoAboutBuilder='" + InfoAboutBuilder + '\'' +
                '}';
    }
}
