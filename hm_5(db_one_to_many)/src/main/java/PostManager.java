import models.Post;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.Scanner;

//class for working with table Post in db
public class PostManager {

    //Create session (for factory object and getting session object from session factory)
    public Session session; //= HibernateSessionFactoryUtil.getSessionFactory().openSession();

    //Constructor
    public PostManager() {

    }

    //show posts - simple show (Powered by ReadPosts)
    public void ShowPosts(){
        //create list and get data from ReadPosts() method
        List<Post> postsList = ReadPosts();

        //show
        for(Post post1 : postsList)
        {
            System.out.println(" -> Post(id: "+post1.getId()+"; title:  "+post1.getTitle()+"; date: "+post1.getDatePosted()+"; message: "+post1.getMessage()+" )");
        }
    }

    ///read users and return list of users
    public List<Post> ReadPosts(){

        //create list
        List<Post> postsList = new ArrayList();

        //Create session factory object and getting session object from session factory
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        //getting transaction object from session object
        session.beginTransaction();

        try {

            //create query, do it and do list
            postsList = session.createQuery("FROM Post").list();

            //return resalt
            return postsList;
        } catch(Exception sqlException) {
            //show exception
            System.out.println("Some go in bad way! (Exeption: "+sqlException.getMessage()+" )");
        } finally {
            //close session
            session.getTransaction().commit();
            session.close();
        }

        //return empty arr
        return postsList;
    }

    //create and return post with random name in some region
    public Post FillRandomAndReturnPost(){
        //create empty user
        Post post1 = new Post();

        //choose region
        int min = 0, max=10000;

        //create random name
        Random random = new Random();
        String str = "post" + random.nextInt((max - min) + 1) + min;

        //show it
        System.out.println(str);

        //set it and return
        post1.setTitle(str);
        return  post1;
    }

    ///add post to DB
    public void AddPost(Post post){

        //first check is exist this user (this we take unique name but it can be any variable)
        boolean flag = true;

        //read all users
        List<Post> usersList = ReadPosts();

        //compare
        for(Post post_item : usersList)
        {
            if(post.getTitle().equals(post_item.getTitle()))
            {
                flag=false;
                break;
            }
        }

        //check is user exist
        if(flag) {

            try {
                //Create session factory object and getting session object from session factory
                session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

                //getting transaction object from session object
                session.beginTransaction();

                //save it in db
                session.save(post);

                //show it for user
                System.out.println("Success add new post! ( "+post.getTitle()+" )");

            } catch(Exception sqlException) {
                //show exception
                System.out.println("Some go in bad way! (Exeption: "+sqlException.getMessage()+" )");
            } finally {
                //close session
                session.getTransaction().commit();
                session.close();
            }
        }
        else {
            System.out.println("This user already exists!");
        }

    }

    //delete post from db by id
    public void DeletePost(int id){

        //first check is exist this post
        boolean flag = IsItemExist(id);

        //check
        if(!flag)
        {
            System.out.println("Post with this id don't exist");
        }
        else {

            //Create session factory object and getting session object from session factory
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

            //getting transaction object from session object
            session.beginTransaction();

            try {
                //find post that must be deleted
                Post post_for_delete = (Post) session.load(Post.class, id);

                //delete from db
                session.delete(post_for_delete);

                //show it for user
                System.out.println("Deleted Successfully");

            } catch (Exception sqlException) {
                //show exception
                System.out.println("Some go in bad way! (Exeption: " + sqlException.getMessage() + " )");
            } finally {
                //close session
                session.getTransaction().commit();
                session.close();
            }
        }

    }

    //find post by id and return it
    public Post GetPostByID(int id){

        //Create session factory object and getting session object from session factory
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        //getting transaction object from session object
        session.beginTransaction();

        //create post
        Post findpost = new Post();

        //find
        try {
            findpost = (Post)session.get(Post.class, id);

        } catch(Exception sqlException) {
            //show exception
            System.out.println("Some go in bad way! (Exeption: "+sqlException.getMessage()+" )");
        } finally {
            //close session
            session.close();
        }

        return findpost;
    }

    //update post in db by user id that we have from user in param
    public void UpdatePost(Post post) {

        //first check is exist this post
        boolean flag = IsItemExist(post.getId());

        //check
        if (!flag) {
            System.out.println("Post with this id don't exist");
        } else {

            //Create session factory object and getting session object from session factory
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

            //getting transaction object from session object
            session.beginTransaction();

            try {
                //update post if we have post with some id
                session.update(post);

                //show resalt for post
                System.out.println("Updated post by #" + post.getId() + " Successfully");

            } catch (Exception sqlException) {
                //show exception
                System.out.println("Some go in bad way! (Exeption: " + sqlException.getMessage() + " )");
            } finally {
                //close session
                session.getTransaction().commit();
                session.close();
            }
        }
    }

    //compare id in params with id of all users and return try if find same as
    public boolean IsItemExist(long id){

        boolean flag = false;

        //read all users
        List<Post> itemsList = ReadPosts();

        //compare IS exist user
        for (Post item : itemsList) {
            if (id == item.getId()) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}