package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;

    @Column(name="accNUmber", nullable=false,length = 250)
    private String AccNumber;

    @Column(name="description", nullable=true,length = 250)
    private String Description;

    public Account(String accNumber, String description) {
        AccNumber = accNumber;
        Description = description;
       // employee = new Employee();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAccNumber() {
        return AccNumber;
    }

    public void setAccNumber(String accNumber) {
        AccNumber = accNumber;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Account() {
        //employee = new Employee();
    }

    public Account(String accNumber, String description, Employee employee) {
        AccNumber = accNumber;
        Description = description;
        this.employee = employee;
    }

    //1. First Variant
    //@OneToOne(mappedBy="account", cascade=CascadeType.ALL)

    //2. Second Variant
    @OneToOne(mappedBy="account")
    private Employee employee;
}
