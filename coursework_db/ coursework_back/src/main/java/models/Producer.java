package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="tbl_Producer")
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;

    @Column(name="companyName", nullable=false,length = 250)
    private String CompanyName;

    @Column(name="country", nullable=true,length = 250)
    private String Country;

    @OneToMany(
            mappedBy = "producer",
            //fetch = FetchType.EAGER
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Product> Products = new ArrayList<>();

    public Producer() {
    }

    public Producer(String companyName, String country) {
        CompanyName = companyName;
        Country = country;
    }

    public Producer(String companyName, String country, List<Product> products) {
        CompanyName = companyName;
        Country = country;
        this.Products = products;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
