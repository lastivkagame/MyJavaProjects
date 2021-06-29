package MyClasses;

public class Product{
    public String name;
    private Money price;

    public Product(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public void ChangePrice(Money value){
        this.price.setCents(this.price.cents - value.cents);
        this.price.setCoins(this.price.coins - value.coins);
        this.price.setEurocents(this.price.eurocents - value.eurocents);

        this.price.setHrn(this.price.hrn - value.hrn);
        this.price.setDollars(this.price.dollars - value.dollars);
        this.price.setEuro(this.price.euro - value.euro);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
