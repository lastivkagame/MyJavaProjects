import models.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Post post1 = new Post("Today News", new Date(2022,12,12), "Today must be a fantastic day)");
        Post post2 = new Post("Yesterday News", new Date(2022,12,11), "??? hm ....  something");
        Author author = new Author("Someone Author");

        PostManager postsManager = new PostManager();
        AuthorManager authorsManager = new AuthorManager();

        postsManager.AddPost(post1);
        postsManager.AddPost(post2);

        postsManager.ShowPosts();

        author.getPosts().add(post1);
        author.getPosts().add(post2);

        authorsManager.AddAuthor(author);

        authorsManager.ShowAuthors();
    }
}
