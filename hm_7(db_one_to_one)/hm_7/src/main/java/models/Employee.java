package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;

    @Column(name="email", nullable=false,length = 250)
    private String Email;

    @Column(name="firstName", nullable=false,length = 250)
    private String FirstName;

    @Column(name="lastName", nullable=false,length = 250)
    private String LastName;


    //1. First Variant
    //@OneToOne(cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn

    //2. Second Variant
    @OneToOne
    @JoinColumn(name="ACCOUNT_ID")
    private Account account;

    public Employee() {
       // account = new Account();
    }

    public Employee(String email, String firstName, String lastName, Account account) {
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        this.account = account;
    }

    public Employee(String email, String firstName, String lastName) {
        Email = email;
        FirstName = firstName;
        LastName = lastName;
       // account = new Account();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}


