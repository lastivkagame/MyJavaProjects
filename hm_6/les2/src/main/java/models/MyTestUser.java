package models;

import javax.persistence.*;

@Entity
@Table(name="tbl_myTestUsers")
public class MyTestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name", nullable = false, length = 250)
    private String name;
    public MyTestUser() {
    }
    public MyTestUser(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public MyTestUser(int id, String name) {
        this.name = name;
        this.id = id;
    }
}