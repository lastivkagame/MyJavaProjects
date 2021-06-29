package myClasses;

public class Car {
    public String name;
    public String mark;
    public int year;
    public double volume;

    //Constructors
    public Car(String name, String mark, int year, double volume) {
        this.name = name;
        this.mark = mark;
        this.year = year;
        this.volume = volume;
    }

    public Car() {
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }

    public int getYear() {
        return year;
    }

    public double getVolume() {
        return volume;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    //Override Methods
    @Override
    public String toString() {
        return "Car{ " +
                "name='" + name + '\'' +
                ", mark='" + mark + '\'' +
                ", year=" + year +
                ", volume=" + volume +
                " }";
    }
}
