import models.MyTestUser;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        List<MyTestUser> usersList = ReadUsers();

        //show
        for(MyTestUser user1 : usersList)
        {
            System.out.println(" -> User(id: "+user1.getId()+"; name:  "+user1.getName()+" )");
        }
    }

    ///read users and return list of users
    public List<MyTestUser> ReadUsers(){

        //create list
        List<MyTestUser> usersList = new ArrayList();

        //Create session factory object and getting session object from session factory
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        //getting transaction object from session object
        session.beginTransaction();

        try {

            //create query, do it and do list
            usersList = session.createQuery("FROM MyTestUser").list();

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
    public MyTestUser FillRandomAndReturnUser(){
        //create empty user
        MyTestUser myTestUser = new MyTestUser();

        //choose region
        int min = 0, max=10000;

        //create random name
        Random random = new Random();
        String str = "someone" + random.nextInt((max - min) + 1) + min + "@mail.com";

        //show it
        System.out.println(str);

        //set it and return
        myTestUser.setName(str);
        return myTestUser;
    }

    ///add user to DB
    public void AddUser(MyTestUser myTestUser){

        //first check is exist this user (this we take unique name but it can be any variable)
       boolean flag = true;

       /*//read all users
       List<MyTestUser> usersList = ReadUsers();

       //compare
        for(MyTestUser user_item : usersList)
        {
            if(myTestUser.getName().equals(user_item.getName()))
            {
                flag=false;
                break;
            }
        }*/

        //check is user exist
        if(flag) {

            try {
            //Create session factory object and getting session object from session factory
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

            //getting transaction object from session object
            session.beginTransaction();

            //save it in db
            session.save(myTestUser);

            //show it for user
            System.out.println("Success add new user! ( "+ myTestUser.getName()+" )");

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
                MyTestUser user_for_delete = (MyTestUser) session.load(MyTestUser.class, id);

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
    public MyTestUser GetUserByID(int id){

        //Create session factory object and getting session object from session factory
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        //getting transaction object from session object
        session.beginTransaction();

        //create user
        MyTestUser finduser = new MyTestUser();

        //find
        try {
            finduser = (MyTestUser)session.get(MyTestUser.class, id);

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
    public void UpdateUser(MyTestUser myTestUser) {

        //first check is exist this user
        boolean flag = IsUserExist(myTestUser.getId());

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
                session.update(myTestUser);

                //show resalt for user
                System.out.println("Updated user by #" + myTestUser.getId() + " Successfully");

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
        List<MyTestUser> usersList = ReadUsers();

        //compare IS exist user
        for (MyTestUser user_item : usersList) {
            if (id == user_item.getId()) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
