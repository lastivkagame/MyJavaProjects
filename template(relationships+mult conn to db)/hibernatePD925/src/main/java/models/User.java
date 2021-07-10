package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="name", nullable = false, length = 250)
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="tblUserRoles",
            joinColumns = {@JoinColumn(name="userId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="roleId", referencedColumnName = "id")}
    )
    private List<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
        fetch = FetchType.LAZY, optional = true)
//    @Column(nullable = true)
    private UserProfile userProfile;

    public User() {
        roles=new ArrayList<Role>();
    }

    public User(String name) {
        this.name = name;
        roles=new ArrayList<Role>();
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
