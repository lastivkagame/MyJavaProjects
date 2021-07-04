import models.User;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//class for working with table User in db
public class UserManager {

    //Create session (for factory object and getting session object from session factory)
   public Session session; //= HibernateSessionFactoryUtil.getSessionFactory().openSession();

    //Constructor
    public UserManager() {

    }

    //show users - simple show (Powered by ReadUsers)
    public void ShowUsers(){
        //create list and get data from ReadUsers() method
        List<User> usersList = ReadUsers();

        //show
        for(User user1 : usersList)
        {
            System.out.println(" -> User(id: "+user1.getId()+"; name:  "+user1.getName()+" )");
        }
    }

    ///read users and return list of users
    public List<User> ReadUsers(){

        //create list
        List<User> usersList = new ArrayList();

        //Create session factory object and getting session object from session factory
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        //getting transaction object from session object
        session.beginTransaction();

        try {

            //create query, do it and do list
            usersList = session.createQuery("FROM User").list();

            //return resalt
            return usersList;
        } catch(Exception sqlException) {
            //show exception
            System.out.println("Some go in bad way! (Exeption: "+sqlException.getMessage()+" )");
        } finally {
            //close session
            session.getTransaction().commit();
            session.close();
        }

        //return empty arr
        return usersList;
    }

    //create and return user with random name in some region
    public User FillRandomAndReturnUser(){
        //create empty user
        User user = new User();

        //choose region
        int min = 0, max=10000;

        //create random name
        Random random = new Random();
        String str = "someone" + random.nextInt((max - min) + 1) + min + "@mail.com";

        //show it
        System.out.println(str);

        //set it and return
        user.setName(str);
        return  user;
    }

    ///add user to DB
    public void AddUser(User user){

        //first check is exist this user (this we take unique name but it can be any variable)
       boolean flag = true;

       //read all users
       List<User> usersList = ReadUsers();

       //compare
        for(User user_item : usersList)
        {
            if(user.getName().equals(user_item.getName()))
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
            session.save(user);

            //show it for user
            System.out.println("Success add new user! ( "+user.getName()+" )");

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

    //delete user from db by id
    public void DeleteUser(int id){

        //first check is exist this user
        boolean flag = IsUserExist(id);

        //check
        if(!flag)
        {
            System.out.println("User with this id don't exist");
        }
        else {

            //Create session factory object and getting session object from session factory
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

            //getting transaction object from session object
            session.beginTransaction();

            try {
                //find user that must be deleted
                User user_for_delete = (User) session.load(User.class, id);

                //delete from db
                session.delete(user_for_delete);

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

    //find user by id and return it
    public User GetUserByID(int id){

        //Create session factory object and getting session object from session factory
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        //getting transaction object from session object
        session.beginTransaction();

        //create user
        User finduser = new User();

        //find
        try {
            finduser = (User)session.get(User.class, id);

        } catch(Exception sqlException) {
            //show exception
            System.out.println("Some go in bad way! (Exeption: "+sqlException.getMessage()+" )");
        } finally {
            //close session
            session.close();
        }

        return finduser;
    }

    //update user in db by user id that we have from user in param
    public void UpdateUser(User user) {

        //first check is exist this user
        boolean flag = IsUserExist(user.getId());

        //check
        if (!flag) {
            System.out.println("User with this id don't exist");
        } else {

            //Create session factory object and getting session object from session factory
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

            //getting transaction object from session object
            session.beginTransaction();

            try {
                //update user if we have user with some id
                session.update(user);

                //show resalt for user
                System.out.println("Updated user by #" + user.getId() + " Successfully");

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
    public boolean IsUserExist(int id){

        boolean flag = false;

        //read all users
        List<User> usersList = ReadUsers();

        //compare IS exist user
        for (User user_item : usersList) {
            if (id == user_item.getId()) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
