package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tbl_CustomerAccount")
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;

    @Column(name="fullName", nullable=false,length = 250)
    private String FullName;

    @Column(name="cardData", nullable=false,length = 250)
    private String CardData;

    @Column(name="password", nullable=false,length = 250)
    private String Password;

    @OneToOne
    @JoinColumn(name="Basket_ID")
    private Basket basket;

    @OneToMany(
            mappedBy = "customerAccount",
            //fetch = FetchType.EAGER
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orders = new ArrayList<>();

    public CustomerAccount(String fullName, String cardData, String password, Basket basket) {
        FullName = fullName;
        CardData = cardData;
        Password = password;
        this.basket = basket;
    }

    public CustomerAccount(String fullName, String cardData, String password, Basket basket, List<Order> orders) {
        FullName = fullName;
        CardData = cardData;
        Password = password;
        this.basket = basket;
        this.orders = orders;
    }

    public CustomerAccount(String fullName, String cardData, String password) {
        FullName = fullName;
        CardData = cardData;
        Password = password;
    }

    public CustomerAccount() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getCardData() {
        return CardData;
    }

    public void setCardData(String cardData) {
        CardData = cardData;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
