package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tbl_Basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="tbl_Product",
            joinColumns = {@JoinColumn(name="product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="basketID", referencedColumnName = "id")}
    )
    private List<Product> products;

    @OneToOne(mappedBy="basket")
    private CustomerAccount customerAccount;

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

    public Basket() {
    }

    public Basket(List<Product> products) {
        this.products = products;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
