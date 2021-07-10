package models;

import javax.persistence.*;

@Entity
@Table(name="tblUserProfile")
public class UserProfile {
    @Id
    private int id;

    private int age;
    @Column(length = 50, nullable = false)
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public UserProfile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
