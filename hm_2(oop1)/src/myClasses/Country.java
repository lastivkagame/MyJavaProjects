package myClasses;

public class Country {
    public String countryName;
    public int population;
    public String location;

    //Constructors
    public Country(String countryName, int population, String location) {
        this.countryName = countryName;
        this.population = population;
        this.location = location;
    }

    public Country() {
    }

    //Getters
    public String getCountryName() {
        return countryName;
    }

    public int getPopulation() {
        return this.population;
    }

    public String getLocation() {
        return this.location;
    }

    //Setters
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //Override Methods
    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", Population=" + this.population +
                ", Location='" + this.location + '\'' +
                '}';
    }
}
