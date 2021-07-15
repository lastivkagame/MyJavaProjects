package app;

import Utils.HibernateSessionFactoryUtil;
import models.*;
import org.hibernate.Session;

public class Program {
    public static void main(String[] args) {
        //Good resources
        //There 4 way create one-to-one relationship, I've tested 2 of them here(and each of them work good)
        //https://github.com/lokeshgupta1981/hibernate/tree/master/hibernate-mappings/src/main/java/com/howtodoinjava/hibernate/onetoone
        //https://howtodoinjava.com/hibernate/hibernate-one-to-one-mapping/

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Account account = new Account();
        account.setAccNumber("123-345-65454");


        // Add new Employee object
        Employee emp = new Employee();
        emp.setEmail("demo-user@mail.com");
        emp.setFirstName("demo");
        emp.setLastName("user");

        // Save Account
        session.saveOrUpdate(account);
        // Save Employee
        emp.setAccount(account);
        session.saveOrUpdate(emp);

        session.getTransaction().commit();
        session.close();
        //HibernateUtil.shutdown();
    }
}
