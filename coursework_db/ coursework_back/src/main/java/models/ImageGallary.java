package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="tbl_ImageGallary")
public class ImageGallary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;

    @Column(name="image", nullable=false,length = 250)
    private String Image;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    /*@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="tbl_Product",
            joinColumns = {@JoinColumn(name="prod_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="imggal_id", referencedColumnName = "id")}
    )
    private List<Product> products;*/

    public ImageGallary() {
    }

    public ImageGallary(String image) {
        Image = image;
    }

    public ImageGallary(String image, Product products) {
        Image = image;
        this.product = products;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Product getProducts() {
        return product;
    }

    public void setProducts(Product products) {
        this.product = products;
    }
}
