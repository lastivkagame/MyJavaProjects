package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_author")
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="fullName", nullable = false, length = 250)
    private String FullName;

    @OneToMany(
            mappedBy = "author",
            //fetch = FetchType.EAGER
           cascade = CascadeType.ALL,
           orphanRemoval = true
    )
    private List<Post> posts = new ArrayList<>();

    //Constructors, getters and setters removed for brevity

    public void addPost(Post post) {
        posts.add(post);
        //posts.setPost(this);
    }

    public void removePost(Post post) {
        posts.remove(post);
        //posts.setPost(null);
    }

    public Author(String fullName, List<Post> posts) {
        FullName = fullName;
        this.posts = posts;
    }

    public Author(String fullName) {
        FullName = fullName;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getFullName() {
        return FullName;
    }

    public List<Post> getPosts() {
        return posts;
    }

/*    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Post> posts = new ArrayList<>();*/

    //Constructors, getters and setters removed for brevity
}


