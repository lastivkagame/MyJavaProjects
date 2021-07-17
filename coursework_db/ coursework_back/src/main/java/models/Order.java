package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tbl_Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="tbl_Product",
            joinColumns = {@JoinColumn(name="product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="orderID", referencedColumnName = "id")}
    )
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerAccount customerAccount;

    public Order(List<Product> products) {
        this.products = products;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

    public Order() {
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
