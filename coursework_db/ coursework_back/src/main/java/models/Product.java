package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tbl_Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;

    @Column(name="name", nullable=false,length = 250)
    private String Name;

    @Column(name="price", nullable=false,length = 250)
    private Double Price;

    @Column(name="priceValute", nullable=false,length = 250)
    private String PriceValute;

    @Column(name="description", nullable=true,length = 250)
    private String Description;

    @Column(name="rating", nullable=true,length = 250)
    private double Rating;

    //@OneToOne
    //@JoinColumn(name="Producer_ID")
    //@ManyToOne
    //private Producer account;

    @ManyToOne(fetch = FetchType.LAZY)
    private Producer producer;

    @OneToMany(
            mappedBy = "product",
            //fetch = FetchType.EAGER
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ImageGallary> imageGallary = new ArrayList<>();

    /*@ManyToMany(mappedBy = "products")
    private List<ImageGallary> imageGallary;*/


    @ManyToMany(mappedBy = "products")
    private List<Basket> baskets;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    public Product() {
    }

    public Product(String name, double price, String priceValute, String description, double rating) {
        Name = name;
        Price = price;
        PriceValute = priceValute;
        Description = description;
        Rating = rating;
    }

    public Product(String name, Double price, String priceValute, String description, double rating, Producer producer, List<ImageGallary> imageGallary) {
        Name = name;
        Price = price;
        PriceValute = priceValute;
        Description = description;
        Rating = rating;
        this.producer = producer;
        this.imageGallary = imageGallary;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getPriceValute() {
        return PriceValute;
    }

    public void setPriceValute(String priceValute) {
        PriceValute = priceValute;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public List<ImageGallary> getImageGallary() {
        return imageGallary;
    }

    public void setImageGallary(List<ImageGallary> imageGallary) {
        this.imageGallary = imageGallary;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
