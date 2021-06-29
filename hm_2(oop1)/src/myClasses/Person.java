package myClasses;

public class Person {
    private String lastName;
    private String name;

    //Constructors
    public Person() {
    }
    public Person(String lastName, String name) {
        this.lastName = lastName;
        this.name = name;
    }

    //Getters
    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    //Setters
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Override Methods
    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName +
                ", name='" + name +
                '}';
    }
}
