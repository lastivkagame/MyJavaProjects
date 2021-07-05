import models.Author;
import models.Post;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//class for working with table Author in db
public class AuthorManager {

    //Create session (for factory object and getting session object from session factory)
    public Session session; //= HibernateSessionFactoryUtil.getSessionFactory().openSession();

    //Constructor
    public AuthorManager() {

    }

    //show Authors - simple show (Powered by ReadAuthors)
    public void ShowAuthors(){
        //create list and get data from ReadAuthors() method
        List<Author> aythorsList = ReadAuthors();

        //show
        for(Author author1 : aythorsList)
        {
            System.out.println(" -> Post(id: "+author1.getId()+"; fullmname:  "+author1.getFullName()+"; posts: "); //+author1.getPosts()+" )");

           /* for (int i=0;i< author1.getPosts().size(); i++){
                System.out.println("   > "+ author1.getPosts().get(i));
            }*/

            System.out.println("I don't know how show posts by this author, please write me how it do");

            System.out.println(" );");
        }
    }

    ///read Authors and return list of authors
    public List<Author> ReadAuthors(){

        //create list
        List<Author> authorsList = new ArrayList();

        //Create session factory object and getting session object from session factory
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        //getting transaction object from session object
        session.beginTransaction();

        try {

            //create query, do it and do list
            authorsList = session.createQuery("FROM Author ").list();

            //return resalt
            return authorsList;
        } catch(Exception sqlException) {
            //show exception
            System.out.println("Some go in bad way! (Exeption: "+sqlException.getMessage()+" )");
        } finally {
            //close session
            session.getTransaction().commit();
            session.close();
        }

        //return empty arr
        return authorsList;
    }

    //create and return post with random name in some region
    public Author FillRandomAndReturnAuthor(){
        //create empty author
        Author author1 = new Author();

        //choose region
        int min = 0, max=10000;

        //create random name
        Random random = new Random();
        String str = "author" + random.nextInt((max - min) + 1) + min;

        //show it
        System.out.println(str);

        //set it and return
        author1.setFullName(str);
        return  author1;
    }

    ///add author to DB
    public void AddAuthor(Author author){

        //first check is exist this author
        boolean flag = true;

        //read all users
        List<Author> authorsList = ReadAuthors();

        //compare
        for(Author author_item : authorsList)
        {
            if(author.getFullName().equals(author_item.getFullName()))
            {
                flag=false;
                break;
            }
        }

        //check is author exist
        if(flag) {

            try {
                //Create session factory object and getting session object from session factory
                session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

                //getting transaction object from session object
                session.beginTransaction();

                //save it in db
                session.save(author);

                //show it for user
                System.out.println("Success add new author! ( "+author.getFullName()+" )");

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

    //delete author from db by id
    public void Deleteauthor(int id){

        //first check is exist this author
        boolean flag = IsItemExist(id);

        //check
        if(!flag)
        {
            System.out.println("Author with this id don't exist");
        }
        else {

            //Create session factory object and getting session object from session factory
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

            //getting transaction object from session object
            session.beginTransaction();

            try {
                //find post that must be deleted
                Author author_for_delete = (Author) session.load(Author.class, id);

                //delete from db
                session.delete(author_for_delete);

                //show it for Author
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

    //find Author by id and return it
    public Author GetAuthorByID(int id){

        //Create session factory object and getting session object from session factory
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        //getting transaction object from session object
        session.beginTransaction();

        //create post
        Author findAuthor = new Author();

        //find
        try {
            findAuthor = (Author)session.get(Author.class, id);

        } catch(Exception sqlException) {
            //show exception
            System.out.println("Some go in bad way! (Exeption: "+sqlException.getMessage()+" )");
        } finally {
            //close session
            session.close();
        }

        return findAuthor;
    }

    //update Author in db by author id that we have from author in param
    public void UpdateAuthor(Author author) {

        //first check is exist this author
        boolean flag = IsItemExist(author.getId());

        //check
        if (!flag) {
            System.out.println("Author with this id don't exist");
        } else {

            //Create session factory object and getting session object from session factory
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

            //getting transaction object from session object
            session.beginTransaction();

            try {
                //update author if we have author with some id
                session.update(author);

                //show resalt for author
                System.out.println("Updated author by #" + author.getId() + " Successfully");

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
        List<Author> itemsList = ReadAuthors();

        //compare IS exist user
        for (Author item : itemsList) {
            if (id == item.getId()) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}