import models.Book;
import models.Role;
import models.User;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
//        System.out.println("Hello");
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//            System.out.printf("->_");
//            Scanner in = new Scanner(System.in);
//            String name = in.next();
//            System.out.println("Name = "+ name);
//            System.out.println("Working data base....");

            session.beginTransaction();
            Role role = new Role("admin");
            session.save(role);

            User user = new User("Славік");
            user.getRoles().add(role);
            //Save the employee in database
            session.save(user);
            //Commit the transaction
            session.getTransaction().commit();
            session.close();
            //System.out.println("Book id = "+ book.getId());

        }catch(Exception ex) {
            System.out.println("Problem! "+ex.getMessage());
        }
    }
}
