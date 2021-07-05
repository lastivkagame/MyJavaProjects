package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false, length = 250)
    private String title;

    @Column(name="datePosted", nullable = true, length = 25)
    private Date datePosted;

    @Column(name="message", nullable = false, length = 550)
    private String message;

   @ManyToOne(fetch = FetchType.LAZY)
   private Author author;
    //@JoinColumn(name="author_id", nullable=false)

    public Post(String title, Date datePosted, String message) {
        this.title = title;
        this.datePosted = datePosted;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", datePosted=" + datePosted +
                ", message='" + message + '\'' +
                '}';
    }

    public Post(){

    }

    public Post(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public String getMessage() {
        return message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public void setMessage(String message) {
        this.message = message;
    }
//Constructors, getters and setters removed for brevity
}