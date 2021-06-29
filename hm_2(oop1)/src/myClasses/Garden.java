package myClasses;

public class Garden {
    public double area;
    public String planteCulture;

    //Constructors
    public Garden(double area, String planteCulture) {
        this.area = area;
        this.planteCulture = planteCulture;
    }

    public Garden() {
        this.area = 0;
        this.planteCulture = "none";
    }

    //Getters
    public double getArea() {
        return area;
    }

    public String getPlanteCulture() {
        return planteCulture;
    }

    //Setters
    public void setArea(double area) {
        this.area = area;
    }

    public void setPlanteCulture(String planteCulture) {
        this.planteCulture = planteCulture;
    }

    //Override Methods
    @Override
    public String toString() {
        return "Garden{" +
                "area='" + area +
                ", plante culture='" + planteCulture +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Garden))
            return false;

        return this.area == ((Garden) obj).area; //super.equals(obj);
    }
}
